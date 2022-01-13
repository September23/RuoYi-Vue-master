package com.ruoyi.web.controller.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.common.config.RuoYiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.code.kaptcha.Producer;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.service.ISysConfigService;

/**
 * 验证码操作处理
 * 
 * @author ruoyi
 */
@RestController
public class CaptchaController
{
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysConfigService configService;
    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) throws IOException
    {
        // 返回一个AjaxResult类型的对象给前端
        AjaxResult ajax = AjaxResult.success();

        // 看看验证是否开启 验证码这个验证可以关掉的
        boolean captchaOnOff = configService.selectCaptchaOnOff();

        ajax.put("captchaOnOff", captchaOnOff);

        // 如果开启验证 则将ajax返回给前端
        // 如果没有开启 则什么也不返回 直接跳过
        if (!captchaOnOff)
        {
            return ajax;
        }

        // 保存验证码信息
        // 生成一个uuid
        String uuid = IdUtils.simpleUUID();

        // 常量 + uuid 生成一个redis里面验证的key
        // 每一个图片表达式(比如1+2)都有一个对应的verifyKey 通过这个key去redis里面查答案 比如查到答案是3
        // 然后和用户输入的答案进行比较来判断是是否输入正确
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = RuoYiConfig.getCaptchaType();
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            // @前面的表达式
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            // @后面的表达式答案
            code = capText.substring(capText.lastIndexOf("@") + 1);
            // 把@前面的表达式capStr调用方法生成图片
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        // verifyKey 和 code(表达式答案) 存到redis中  Constants.CAPTCHA_EXPIRATION是验证码有效期
        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }
}
