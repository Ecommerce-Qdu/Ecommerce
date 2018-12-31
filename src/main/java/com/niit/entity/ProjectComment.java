package com.niit.entity;


import java.sql.Date;

public class ProjectComment {
    private Integer pcid;

    private Integer cpid;

    private Date pctime;

    private String pcomment;

    private String uphone;

    private Users usersByUPhone;
    
    private Project projectByCPid;

    @Override
    public String toString() {
        return "ProjectComment{" +
                "pcid=" + pcid +
                ", cpid=" + cpid +
                ", pctime=" + pctime +
                ", pcomment='" + pcomment + '\'' +
                ", uphone='" + uphone + '\'' +
                ", usersByUPhone=" + usersByUPhone +
                ", projectByCPid=" + projectByCPid +
                '}';
    }


    public ProjectComment(Integer pcid, Integer cpid, Date pctime, String pcomment, String uphone, Users usersByUPhone, Project projectByCPid) {
        this.pcid = pcid;
        this.cpid = cpid;
        this.pctime = pctime;
        this.pcomment = pcomment;
        this.uphone = uphone;
        this.usersByUPhone = usersByUPhone;
        this.projectByCPid = projectByCPid;
    }
    
    public Project getProjectByCPid() {
        return projectByCPid;
    }
    
    public void setProjectByCPid(Project projectByCPid) {
        this.projectByCPid = projectByCPid;
    }
    
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

    public Users getUsersByUPhone() {
        return usersByUPhone;
    }

    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }

    public ProjectComment(Integer pcid, Integer cpid, Date pctime, String pcomment, String uphone, Users usersByUPhone) {
        this.pcid = pcid;
        this.cpid = cpid;
        this.pctime = pctime;
        this.pcomment = pcomment;
        this.uphone = uphone;
        this.usersByUPhone = usersByUPhone;
    }

    public ProjectComment() {
    }
}