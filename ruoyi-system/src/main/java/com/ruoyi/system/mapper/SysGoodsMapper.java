package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGoods;

/**
 * 商品Mapper接口
 * 
 * @author wyx
 * @date 2022-01-13
 */
public interface SysGoodsMapper 
{
    /**
     * 查询商品
     * 
     * @param goodsId 商品主键
     * @return 商品
     */
    public SysGoods selectSysGoodsByGoodsId(Long goodsId);

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品集合
     */
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods);

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int insertSysGoods(SysGoods sysGoods);

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int updateSysGoods(SysGoods sysGoods);

    /**
     * 删除商品
     * 
     * @param goodsId 商品主键
     * @return 结果
     */
    public int deleteSysGoodsByGoodsId(Long goodsId);

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysGoodsByGoodsIds(Long[] goodsIds);
}
