package com.niit.entity;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    private Users usersByUPhone;

    public Users getUsersByUPhone() {
        return usersByUPhone;
    }

    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }

    private UsersAddress usersAddressByAId;

    private Project projectByPId;

    private String timestr;

    public String getTimestr() {
        return timestr;
    }

    public void setTimestr(String timestr) {
        this.timestr = timestr;
    }

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

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", uphone='" + uphone + '\'' +
                ", pid=" + pid +
                ", aid=" + aid +
                ", money=" + money +
                ", expect=" + expect +
                ", expecttype=" + expecttype +
                ", exceptother='" + exceptother + '\'' +
                ", orderdate=" + orderdate +
                ", usersAddressByAId=" + usersAddressByAId +
                ", projectByPId=" + projectByPId +
                '}';
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

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        timestr = dateFormat.format(orderdate);

        this.orderdate = orderdate;
    }
}