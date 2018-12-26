package com.niit.entity;

import java.util.Date;

public class ProjectComment {
    private Integer pcid;

    private Integer cpid;

    private Date pctime;

    private String pcomment;

    private String uphone;

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Date getPctime() {
        return pctime;
    }

    public void setPctime(Date pctime) {
        this.pctime = pctime;
    }

    public String getPcomment() {
        return pcomment;
    }

    public void setPcomment(String pcomment) {
        this.pcomment = pcomment == null ? null : pcomment.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }


}