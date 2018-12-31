package com.niit.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    private List<ProjectComment> projectCommentsByPId;

    private List<ProjectImg> projectImgList;

    private List<Orders> ordersByPId;

    private ProjectType projectTypeByPCategoryId;

    private String timestr;


    public String getTimestr() {
        return timestr;
    }

    public void setTimestr(String timestr) {
        this.timestr = timestr;
    }

    public Project(String pname, String pdesc, Date psd, Date ped, BigDecimal ptarget, BigDecimal pnm, Integer pnp, String pmilestone, String premark, Integer pmf, Integer plimit, String pteam, Integer pstate, String pplan, Users u, ProjectType projectType) {
        this.pname = pname;
        this.pdesc = pdesc;
        this.psd = psd;
        this.ped = ped;
        this.ptarget = ptarget;
        this.pnm = pnm;
        this.pnp = pnp;
        this.pmilestone = pmilestone;
        this.premark = premark;
        this.pmf = pmf;
        this.plimit = plimit;
        this.pteam = pteam;
        this.pstate = pstate;
        this.pplan = pplan;
        this.uphone = u.getUphone();
        this.pcategoryid = projectType.getProjecttypeid();
    }
    
    public ProjectType getProjectTypeByPCategoryId() {
        return projectTypeByPCategoryId;
    }

    public void setProjectTypeByPCategoryId(ProjectType projectTypeByPCategoryId) {
        this.projectTypeByPCategoryId = projectTypeByPCategoryId;
    }

    public List<Orders> getOrdersByPId() {
        return ordersByPId;
    }

    public void setOrdersByPId(List<Orders> ordersByPId) {
        this.ordersByPId = ordersByPId;
    }

    public List<ProjectComment> getProjectCommentsByPId() {
        return projectCommentsByPId;
    }

    public void setProjectCommentsByPId(List<ProjectComment> projectCommentsByPId) {
        this.projectCommentsByPId = projectCommentsByPId;
    }


    public List<ProjectImg> getProjectImgList() {
        return projectImgList;
    }

    public void setProjectImgList(List<ProjectImg> projectImgList) {
        this.projectImgList = projectImgList;
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
    
    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", uphone='" + uphone + '\'' +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", psd=" + psd +
                ", ped=" + ped +
                ", ptarget=" + ptarget +
                ", pnm=" + pnm +
                ", pnp=" + pnp +
                ", pmilestone='" + pmilestone + '\'' +
                ", pcategoryid=" + pcategoryid +
                ", premark='" + premark + '\'' +
                ", pmf=" + pmf +
                ", plimit=" + plimit +
                ", pteam='" + pteam + '\'' +
                ", pstate=" + pstate +
                ", pplan='" + pplan + '\'' +
                ", projectCommentsByPId=" + projectCommentsByPId +
                ", projectImgList=" + projectImgList +
                ", ordersByPId=" + ordersByPId +
                ", projectTypeByPCategoryId=" + projectTypeByPCategoryId +
                '}';
    }
    
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
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

//    public Date getPed() {
//        return ped;
//    }

    public Timestamp getPed() {
        return new Timestamp(ped.getTime());
    }

    public void setPed(Date ped) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        timestr = dateFormat.format(ped);

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

    public Project(Integer pid, String uphone, String pname, String pdesc, Date psd, Date ped, BigDecimal ptarget, BigDecimal pnm, Integer pnp, String pmilestone, Integer pcategoryid, String premark, Integer pmf, Integer plimit, String pteam, Integer pstate, String pplan) {
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
    }

    public Project(Integer pid, String uphone, String pname, String pdesc, Date psd, Date ped, BigDecimal ptarget, BigDecimal pnm, Integer pnp, String pmilestone, Integer pcategoryid, String premark, Integer pmf, Integer plimit, String pteam, Integer pstate, String pplan, List<ProjectComment> projectCommentsByPId, List<ProjectImg> projectImgList, List<Orders> ordersByPId, ProjectType projectTypeByPCategoryId) {
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
        this.projectCommentsByPId = projectCommentsByPId;
        this.projectImgList = projectImgList;
        this.ordersByPId = ordersByPId;
        this.projectTypeByPCategoryId = projectTypeByPCategoryId;
    }

    public Project() {
    }
}