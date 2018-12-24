package com.niit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer orderid;

    private String uphone;

    private Integer pid;

    private Integer aid;

    private BigDecimal money;

    private Integer expect;

    private Integer expecttype;

    private String exceptother;

    private Date orderdate;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getExpect() {
        return expect;
    }

    public void setExpect(Integer expect) {
        this.expect = expect;
    }

    public Integer getExpecttype() {
        return expecttype;
    }

    public void setExpecttype(Integer expecttype) {
        this.expecttype = expecttype;
    }

    public String getExceptother() {
        return exceptother;
    }

    public void setExceptother(String exceptother) {
        this.exceptother = exceptother == null ? null : exceptother.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}