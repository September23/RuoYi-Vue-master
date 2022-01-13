package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WyxDemo;

/**
 * 打卡信息Mapper接口
 * 
 * @author wyx
 * @date 2022-01-13
 */
public interface WyxDemoMapper 
{
    /**
     * 查询打卡信息
     * 
     * @param userId 打卡信息主键
     * @return 打卡信息
     */
    public WyxDemo selectWyxDemoByUserId(Long userId);

    /**
     * 查询打卡信息列表
     * 
     * @param wyxDemo 打卡信息
     * @return 打卡信息集合
     */
    public List<WyxDemo> selectWyxDemoList(WyxDemo wyxDemo);

    /**
     * 新增打卡信息
     * 
     * @param wyxDemo 打卡信息
     * @return 结果
     */
    public int insertWyxDemo(WyxDemo wyxDemo);

    /**
     * 修改打卡信息
     * 
     * @param wyxDemo 打卡信息
     * @return 结果
     */
    public int updateWyxDemo(WyxDemo wyxDemo);

    /**
     * 删除打卡信息
     * 
     * @param userId 打卡信息主键
     * @return 结果
     */
    public int deleteWyxDemoByUserId(Long userId);

    /**
     * 批量删除打卡信息
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWyxDemoByUserIds(Long[] userIds);
}
