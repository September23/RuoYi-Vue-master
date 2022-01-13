package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WyxDemoMapper;
import com.ruoyi.system.domain.WyxDemo;
import com.ruoyi.system.service.IWyxDemoService;

/**
 * 打卡信息Service业务层处理
 * 
 * @author wyx
 * @date 2022-01-13
 */
@Service
public class WyxDemoServiceImpl implements IWyxDemoService 
{
    @Autowired
    private WyxDemoMapper wyxDemoMapper;

    /**
     * 查询打卡信息
     * 
     * @param userId 打卡信息主键
     * @return 打卡信息
     */
    @Override
    public WyxDemo selectWyxDemoByUserId(Long userId)
    {
        return wyxDemoMapper.selectWyxDemoByUserId(userId);
    }

    /**
     * 查询打卡信息列表
     * 
     * @param wyxDemo 打卡信息
     * @return 打卡信息
     */
    @Override
    public List<WyxDemo> selectWyxDemoList(WyxDemo wyxDemo)
    {
        return wyxDemoMapper.selectWyxDemoList(wyxDemo);
    }

    /**
     * 新增打卡信息
     * 
     * @param wyxDemo 打卡信息
     * @return 结果
     */
    @Override
    public int insertWyxDemo(WyxDemo wyxDemo)
    {
        return wyxDemoMapper.insertWyxDemo(wyxDemo);
    }

    /**
     * 修改打卡信息
     * 
     * @param wyxDemo 打卡信息
     * @return 结果
     */
    @Override
    public int updateWyxDemo(WyxDemo wyxDemo)
    {
        return wyxDemoMapper.updateWyxDemo(wyxDemo);
    }

    /**
     * 批量删除打卡信息
     * 
     * @param userIds 需要删除的打卡信息主键
     * @return 结果
     */
    @Override
    public int deleteWyxDemoByUserIds(Long[] userIds)
    {
        return wyxDemoMapper.deleteWyxDemoByUserIds(userIds);
    }

    /**
     * 删除打卡信息信息
     * 
     * @param userId 打卡信息主键
     * @return 结果
     */
    @Override
    public int deleteWyxDemoByUserId(Long userId)
    {
        return wyxDemoMapper.deleteWyxDemoByUserId(userId);
    }
}
