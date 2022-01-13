package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysProduct;

/**
 * 产品Service接口
 * 
 * @author wyx
 * @date 2022-01-12
 */
public interface ISysProductService 
{
    /**
     * 查询产品
     * 
     * @param productId 产品主键
     * @return 产品
     */
    public SysProduct selectSysProductByProductId(Long productId);

    /**
     * 查询产品列表
     * 
     * @param sysProduct 产品
     * @return 产品集合
     */
    public List<SysProduct> selectSysProductList(SysProduct sysProduct);

    /**
     * 新增产品
     * 
     * @param sysProduct 产品
     * @return 结果
     */
    public int insertSysProduct(SysProduct sysProduct);

    /**
     * 修改产品
     * 
     * @param sysProduct 产品
     * @return 结果
     */
    public int updateSysProduct(SysProduct sysProduct);

    /**
     * 批量删除产品
     * 
     * @param productIds 需要删除的产品主键集合
     * @return 结果
     */
    public int deleteSysProductByProductIds(Long[] productIds);

    /**
     * 删除产品信息
     * 
     * @param productId 产品主键
     * @return 结果
     */
    public int deleteSysProductByProductId(Long productId);
}
