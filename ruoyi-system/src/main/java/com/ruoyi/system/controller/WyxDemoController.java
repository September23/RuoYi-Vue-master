package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.WyxDemo;
import com.ruoyi.system.service.IWyxDemoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打卡信息Controller
 * 
 * @author wyx
 * @date 2022-01-13
 */
@RestController
@RequestMapping("/system/clock")
public class WyxDemoController extends BaseController
{
    @Autowired
    private IWyxDemoService wyxDemoService;

    /**
     * 查询打卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:clock:list')")
    @GetMapping("/list")
    public TableDataInfo list(WyxDemo wyxDemo)
    {
        startPage();
        List<WyxDemo> list = wyxDemoService.selectWyxDemoList(wyxDemo);
        return getDataTable(list);
    }

    /**
     * 导出打卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:clock:export')")
    @Log(title = "打卡信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WyxDemo wyxDemo)
    {
        List<WyxDemo> list = wyxDemoService.selectWyxDemoList(wyxDemo);
        ExcelUtil<WyxDemo> util = new ExcelUtil<WyxDemo>(WyxDemo.class);
        util.exportExcel(response, list, "打卡信息数据");
    }

    /**
     * 获取打卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:clock:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(wyxDemoService.selectWyxDemoByUserId(userId));
    }

    /**
     * 新增打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clock:add')")
    @Log(title = "打卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WyxDemo wyxDemo)
    {
        return toAjax(wyxDemoService.insertWyxDemo(wyxDemo));
    }

    /**
     * 修改打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clock:edit')")
    @Log(title = "打卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WyxDemo wyxDemo)
    {
        return toAjax(wyxDemoService.updateWyxDemo(wyxDemo));
    }

    /**
     * 删除打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clock:remove')")
    @Log(title = "打卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(wyxDemoService.deleteWyxDemoByUserIds(userIds));
    }
}
