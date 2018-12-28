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
    
    private UsersAddress usersAddressByAId;
    
    private Project projectByPId;
    
    public Orders(Integer orderid, String uphone, Integer pid, Integer aid, BigDecimal money, Integer expect, Integer expecttype, String exceptother, Date orderdate, UsersAddress usersAddressByAId, Project projectByPId) {
        this.orderid = orderid;
        this.uphone = uphone;
        this.pid = pid;
        this.aid = aid;
        this.money = money;
        this.expect = expect;
        this.expecttype = expecttype;
        this.exceptother = exceptother;
        this.orderdate = orderdate;
        this.usersAddressByAId = usersAddressByAId;
        this.projectByPId = projectByPId;
    }
    
    public UsersAddress getUsersAddressByAId() {
        return usersAddressByAId;
    }
    
    public void setUsersAddressByAId(UsersAddress usersAddressByAId) {
        this.usersAddressByAId = usersAddressByAId;
    }
    
    public Orders() {
        this.orderid = orderid;
        this.uphone = uphone;
        this.pid = pid;
        this.aid = aid;
        this.money = money;
        this.expect = expect;
        this.expecttype = expecttype;
        this.exceptother = exceptother;
        this.orderdate = orderdate;
        this.projectByPId = projectByPId;
    }
    
    public Project getProjectByPId() {
        return projectByPId;
    }
    
    public void setProjectByPId(Project projectByPId) {
        this.projectByPId = projectByPId;
    }
    

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