package com.niit.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Project {
    private Integer pid;

    private String uphone;

    private String pname;

    private String pdesc;

    private Date psd;

    private Date ped;

    private BigDecimal ptarget;

    private BigDecimal pnm;

    private Integer pnp;

    private String pmilestone;

    private Integer pcategoryid;

    private String premark;

    private Integer pmf;

    private Integer plimit;

    private String pteam;

    private Integer pstate;

    private String pplan;
    
    private Collection<Orders> ordersByPId;
    private Users usersByUPhone;
    private ProjectType projectTypeByPCategoryId;
    private Collection<ProjectComment> projectCommentsByPId;
    private Collection<ProjectImg> projectImgsByPId;
    
    public Collection<Orders> getOrdersByPId() {
        return ordersByPId;
    }
    
    public void setOrdersByPId(Collection<Orders> ordersByPId) {
        this.ordersByPId = ordersByPId;
    }
    
    public Users getUsersByUPhone() {
        return usersByUPhone;
    }
    
    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }
    
    public ProjectType getProjectTypeByPCategoryId() {
        return projectTypeByPCategoryId;
    }
    
    public void setProjectTypeByPCategoryId(ProjectType projectTypeByPCategoryId) {
        this.projectTypeByPCategoryId = projectTypeByPCategoryId;
    }
    
    public Collection<ProjectComment> getProjectCommentsByPId() {
        return projectCommentsByPId;
    }
    
    public void setProjectCommentsByPId(Collection<ProjectComment> projectCommentsByPId) {
        this.projectCommentsByPId = projectCommentsByPId;
    }
    
    public Collection<ProjectImg> getProjectImgsByPId() {
        return projectImgsByPId;
    }
    
    public void setProjectImgsByPId(Collection<ProjectImg> projectImgsByPId) {
        this.projectImgsByPId = projectImgsByPId;
    }
    
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
    
    public Project(Integer pid, String uphone, String pname, String pdesc, Date psd, Date ped, BigDecimal ptarget, BigDecimal pnm, Integer pnp, String pmilestone, Integer pcategoryid, String premark, Integer pmf, Integer plimit, String pteam, Integer pstate, String pplan, Collection<Orders> ordersByPId, Users usersByUPhone, ProjectType projectTypeByPCategoryId, Collection<ProjectComment> projectCommentsByPId, Collection<ProjectImg> projectImgsByPId) {
        this.pid = pid;
        this.uphone = uphone;
        this.pname = pname;
        this.pdesc = pdesc;
        this.psd = psd;
        this.ped = ped;
        this.ptarget = ptarget;
        this.pnm = pnm;
        this.pnp = pnp;
        this.pmilestone = pmilestone;
        this.pcategoryid = pcategoryid;
        this.premark = premark;
        this.pmf = pmf;
        this.plimit = plimit;
        this.pteam = pteam;
        this.pstate = pstate;
        this.pplan = pplan;
        this.ordersByPId = ordersByPId;
        this.usersByUPhone = usersByUPhone;
        this.projectTypeByPCategoryId = projectTypeByPCategoryId;
        this.projectCommentsByPId = projectCommentsByPId;
        this.projectImgsByPId = projectImgsByPId;
    }
    
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Date getPsd() {
        return psd;
    }

    public void setPsd(Date psd) {
        this.psd = psd;
    }

    public Date getPed() {
        return ped;
    }

    public void setPed(Date ped) {
        this.ped = ped;
    }

    public BigDecimal getPtarget() {
        return ptarget;
    }

    public void setPtarget(BigDecimal ptarget) {
        this.ptarget = ptarget;
    }

    public BigDecimal getPnm() {
        return pnm;
    }

    public void setPnm(BigDecimal pnm) {
        this.pnm = pnm;
    }

    public Integer getPnp() {
        return pnp;
    }

    public void setPnp(Integer pnp) {
        this.pnp = pnp;
    }

    public String getPmilestone() {
        return pmilestone;
    }

    public void setPmilestone(String pmilestone) {
        this.pmilestone = pmilestone == null ? null : pmilestone.trim();
    }

    public Integer getPcategoryid() {
        return pcategoryid;
    }

    public void setPcategoryid(Integer pcategoryid) {
        this.pcategoryid = pcategoryid;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark == null ? null : premark.trim();
    }

    public Integer getPmf() {
        return pmf;
    }

    public void setPmf(Integer pmf) {
        this.pmf = pmf;
    }

    public Integer getPlimit() {
        return plimit;
    }

    public void setPlimit(Integer plimit) {
        this.plimit = plimit;
    }

    public String getPteam() {
        return pteam;
    }

    public void setPteam(String pteam) {
        this.pteam = pteam == null ? null : pteam.trim();
    }

    public Integer getPstate() {
        return pstate;
    }

    public void setPstate(Integer pstate) {
        this.pstate = pstate;
    }

    public String getPplan() {
        return pplan;
    }

    public void setPplan(String pplan) {
        this.pplan = pplan == null ? null : pplan.trim();
    }
}