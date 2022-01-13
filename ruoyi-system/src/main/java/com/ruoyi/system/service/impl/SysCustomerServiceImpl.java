package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.mapper.SysCustomerMapper;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;

/**
 * 客户Service业务层处理
 * 
 * @author wyx
 * @date 2022-01-13
 */
@Service
public class SysCustomerServiceImpl implements ISysCustomerService 
{
    @Autowired
    private SysCustomerMapper sysCustomerMapper;

    /**
     * 查询客户
     * 
     * @param customerId 客户主键
     * @return 客户
     */
    @Override
    public SysCustomer selectSysCustomerByCustomerId(Long customerId)
    {
        return sysCustomerMapper.selectSysCustomerByCustomerId(customerId);
    }

    /**
     * 查询客户列表
     * 
     * @param sysCustomer 客户
     * @return 客户
     */
    @Override
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer)
    {
        return sysCustomerMapper.selectSysCustomerList(sysCustomer);
    }

    /**
     * 新增客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysCustomer(SysCustomer sysCustomer)
    {
        int rows = sysCustomerMapper.insertSysCustomer(sysCustomer);
        insertSysGoods(sysCustomer);
        return rows;
    }

    /**
     * 修改客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysCustomer(SysCustomer sysCustomer)
    {
        sysCustomerMapper.deleteSysGoodsByCustomerId(sysCustomer.getCustomerId());
        insertSysGoods(sysCustomer);
        return sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    /**
     * 批量删除客户
     * 
     * @param customerIds 需要删除的客户主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysCustomerByCustomerIds(Long[] customerIds)
    {
        sysCustomerMapper.deleteSysGoodsByCustomerIds(customerIds);
        return sysCustomerMapper.deleteSysCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除客户信息
     * 
     * @param customerId 客户主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysCustomerByCustomerId(Long customerId)
    {
        sysCustomerMapper.deleteSysGoodsByCustomerId(customerId);
        return sysCustomerMapper.deleteSysCustomerByCustomerId(customerId);
    }

    /**
     * 新增商品信息
     * 
     * @param sysCustomer 客户对象
     */
    public void insertSysGoods(SysCustomer sysCustomer)
    {
        List<SysGoods> sysGoodsList = sysCustomer.getSysGoodsList();
        Long customerId = sysCustomer.getCustomerId();
        if (StringUtils.isNotNull(sysGoodsList))
        {
            List<SysGoods> list = new ArrayList<SysGoods>();
            for (SysGoods sysGoods : sysGoodsList)
            {
                sysGoods.setCustomerId(customerId);
                list.add(sysGoods);
            }
            if (list.size() > 0)
            {
                sysCustomerMapper.batchSysGoods(list);
            }
        }
    }
}
