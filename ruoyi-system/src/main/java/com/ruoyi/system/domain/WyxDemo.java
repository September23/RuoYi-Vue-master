package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打卡信息对象 wyx_demo
 * 
 * @author wyx
 * @date 2022-01-13
 */
public class WyxDemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    private Long userId;

    /** 员工名字 */
    @Excel(name = "员工名字")
    private String userName;

    /** 部门编号 */
    @Excel(name = "部门编号")
    private Long deptId;

    /** 打卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "打卡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clockTime;

    /** 状态(0上班 1下班 2请假) */
    @Excel(name = "状态(0上班 1下班 2请假)")
    private String clockStatus;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setClockTime(Date clockTime) 
    {
        this.clockTime = clockTime;
    }

    public Date getClockTime() 
    {
        return clockTime;
    }
    public void setClockStatus(String clockStatus) 
    {
        this.clockStatus = clockStatus;
    }

    public String getClockStatus() 
    {
        return clockStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("deptId", getDeptId())
            .append("clockTime", getClockTime())
            .append("clockStatus", getClockStatus())
            .toString();
    }
}
