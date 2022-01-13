package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGoodsMapper;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.service.ISysGoodsService;

/**
 * 商品Service业务层处理
 * 
 * @author wyx
 * @date 2022-01-13
 */
@Service
public class SysGoodsServiceImpl implements ISysGoodsService 
{
    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    /**
     * 查询商品
     * 
     * @param goodsId 商品主键
     * @return 商品
     */
    @Override
    public SysGoods selectSysGoodsByGoodsId(Long goodsId)
    {
        return sysGoodsMapper.selectSysGoodsByGoodsId(goodsId);
    }

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品
     */
    @Override
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods)
    {
        return sysGoodsMapper.selectSysGoodsList(sysGoods);
    }

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Override
    public int insertSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.insertSysGoods(sysGoods);
    }

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Override
    public int updateSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.updateSysGoods(sysGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteSysGoodsByGoodsIds(Long[] goodsIds)
    {
        return sysGoodsMapper.deleteSysGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除商品信息
     * 
     * @param goodsId 商品主键
     * @return 结果
     */
    @Override
    public int deleteSysGoodsByGoodsId(Long goodsId)
    {
        return sysGoodsMapper.deleteSysGoodsByGoodsId(goodsId);
    }
}
