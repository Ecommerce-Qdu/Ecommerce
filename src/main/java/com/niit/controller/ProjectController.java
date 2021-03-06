package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.*;
import com.niit.utils.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;

@Controller
public class ProjectController {
    @Autowired
    private IProjectBiz projectBiz;
    @Autowired
    private IUserBiz userBiz;
    @Autowired
    private Exchange exchange;

    @RequestMapping(value = "AddProject.mvc", method = RequestMethod.POST)
    public String AddProject(ModelMap map, HttpSession session, String PName, String PDesc, String PSD, String PED, String PTarget, String
            PMilestone, String PCategoryId, String PRemark, String PMF, String PLimit, String PTeam, String PPlan) throws ParseException {
        Project project = new Project();
        try {
            PSD = PSD.replace("T", " ") + ":00.000";
            PED = PED.replace("T", " ") + ":00.000";
            System.out.println("PSD = " + PSD);
            System.out.println("PED = " + PED);

            Timestamp tss = Timestamp.valueOf(PSD);
            Timestamp tnow = new Timestamp(System.currentTimeMillis());
            Timestamp tse = Timestamp.valueOf(PED);
            System.out.println("tnow = " + tnow);
            int plimit = Integer.parseInt(PLimit);
            int ppid = Integer.parseInt(PCategoryId);
            int pmf = Integer.parseInt(PMF);
            BigDecimal pt = BigDecimal.valueOf(Long.parseLong(PTarget));
            BigDecimal pnm = BigDecimal.valueOf(0);
            ProjectType projectType = new ProjectType();
            projectType.setProjecttypeid(ppid);
            Users u = (Users) session.getAttribute("user");
            String phone = u.getUphone();
            System.out.println("checkForm");
    
            System.out.println("**************");
            System.out.println(PName);
            System.out.println(PDesc);
            System.out.println(tss);
            System.out.println(tse);
            
            project = new Project(PName, PDesc, tss, tse, pt,
                    pnm, 0, PMilestone, PRemark, pmf, plimit, PTeam, 0, PPlan, u, projectType);
            System.out.println("**************");
            System.out.println(project.toString());
            project.setPsd(tss);
            if (tss.after(tnow)) {
                project.setPstate(0);
            } else {
                project.setPstate(1);
            }
            if (tnow.after(tse)) {
                if (pnm.equals(pt)) {
                    project.setPstate(2);
                } else {
                    project.setPstate(3);
                }
            }


        } catch (Exception e) {
            map.addAttribute("existaddprojectmsg", "true");
            map.addAttribute("addprojectmsg", "输入内容有误");
            return "addproject.jsp";
        }

        
        int isok = projectBiz.save(project);
        System.out.println("isok = "+isok);
        if (isok >= 0) {
            session.setAttribute("addprojectid", isok);
            map.addAttribute("msg", "添加项目成功,请上传图片");
            map.addAttribute("url", "upload.jsp");
            map.addAttribute("existaddprojectmsg", "false");
        } else {
            map.addAttribute("msg", "添加项目失败");
            map.addAttribute("url", "addproject.jsp");
        }

        return "msg.jsp";
    }


    @RequestMapping(value = "Upload.mvc", method = RequestMethod.POST)
    private String fildUpload(@RequestParam(value = "itemImagers", required = false) MultipartFile[] file,
                              HttpSession session, ModelMap map) throws Exception {

        //新增项目1,更新项目2,更新图片3
        int flag = 1;

        int pid = 0;
        try {
            pid = (int) session.getAttribute("addprojectid");
        } catch (Exception e) {
            Project up = (Project) session.getAttribute("updateproject");
            pid = up.getPid();
            if (file.length == 0) {
                flag = 2;
            } else {
                flag = 3;
            }
        }
        String pathRoot = session.getServletContext().getRealPath("");//获取当前项目绝对路径
        String path = "";
        String imgpath = "";

        String savePath = pathRoot + "/images/" + pid + "/";//当前运行环境的图片文件夹下的对应pid的文件夹

        //若果不存在文件夹则创建
        File dirFile;
        File tempFile;
        boolean bFile;
        String sFileName;
        bFile = false;
        try {
            dirFile = new File(savePath); //检查文件目录是否存在，不存在则创建
            bFile = dirFile.exists();
            if (bFile == true) {
            } else {
                bFile = dirFile.mkdir();
            }
        } catch (Exception e) {
            System.out.println("创建文件夹失败!");
        }

        if (flag != 3) {
            //保存图片
            List<String> listImagePath = new ArrayList<String>();
            boolean upload = true;
            System.out.println("file = " + file.length);
            System.out.println("flag = " + flag);
            //判断用户是否上传了图片
            if (file[0].isEmpty() && flag == 1) {
                map.addAttribute("msg", "请上传图片");
                map.addAttribute("url", "upload.jsp");
            } else {
                for (MultipartFile mf : file) {
                    if (!mf.isEmpty()) {

                        //得到文件名
                        File countfile = new File(savePath);
                        String[] files = countfile.list();
                        int i = files.length;

                        //获得文件类型
                        String contentType = mf.getContentType();
                        System.out.println("contentType = " + contentType);
                        if ("image/jpeg".equals(contentType)) {
                            path = "/images/" + pid + "/" + i + ".jpg";
                            imgpath = "images/" + pid + "/" + i + ".jpg";
                            mf.transferTo(new File(pathRoot + path)); //把文件数组里的文件放到指定路径
                            listImagePath.add(imgpath);
                            System.out.println(imgpath);
                        } else {
                            map.addAttribute("msg", "图片类型不正确");
                            map.addAttribute("url", "upload.jsp");
                            //失败清空list
                            upload = false;
                            listImagePath = new ArrayList<String>();
                        }
                    }
                }
                boolean isok=false;
                if(projectBiz.saveimg(pid, listImagePath)>0) {
                    isok=true;
                } else {
                    isok=false;
                }
                if (upload && isok) {
                    map.addAttribute("msg", "添加图片成功");
                    map.addAttribute("url", "ShowProject.mvc?pid=" + pid);
                    session.setAttribute("addprojectid", null);
                }
            }
            return "msg.jsp";
        } else {
            return "manage_myproject.jsp";
        }


    }

    @RequestMapping(value = "PreUpdateProject.mvc")
    public String PreUpdateProject(String pid, ModelMap map, HttpSession session) {

        Project project = projectBiz.findProjectById(Integer.parseInt(pid));

        session.setAttribute("updateproject", project);

        return "updateproject.jsp";
    }

    @RequestMapping(value = "UpdateProject.mvc")
    public String UpdateProject(ModelMap map, HttpSession session, String PName, String PDesc, String PSD, String PED, String PTarget, String
            PMilestone, String PCategoryId, String PRemark, String PMF, String PLimit, String PTeam, String PPlan) throws ParseException {

        Project project = null;
        try {
            PSD = PSD.replace("T", " ")+":00";
            PED = PED.replace("T", " ")+":00";
            Timestamp tss = Timestamp.valueOf(PSD);
            Timestamp tse = Timestamp.valueOf(PED);

            int plimit = Integer.parseInt(PLimit);
            int ppid = Integer.parseInt(PCategoryId);
            int pmf = Integer.parseInt(PMF);
            System.out.println("PTarget = " + PTarget);
            BigDecimal pt = new BigDecimal(PTarget);

            System.out.println("pt = " + pt);
            ProjectType projectType = new ProjectType();
            projectType.setProjecttypeid(ppid);
            Users u = (Users) session.getAttribute("user");
            String phone = u.getUphone();
            System.out.println("phone = " + phone);
            project = (Project) session.getAttribute("updateproject");
            System.out.println("project = " + project);
            project.setPname(PName);
            project.setPdesc(PDesc);
            project.setPsd(tss);
            project.setPed(tse);
            project.setPtarget(pt);
            project.setPmilestone(PMilestone);
            project.setProjectTypeByPCategoryId(projectType);
            project.setPremark(PRemark);
            project.setPmf(pmf);
            project.setPlimit(plimit);
            project.setPteam(PTeam);
            project.setPplan(PPlan);

            Timestamp tnow = new Timestamp(System.currentTimeMillis());
            System.out.println("tnow = " + tnow);
            if (tss.after(tnow)) {
                project.setPstate(0);
            } else {
                project.setPstate(1);
            }
            if (tnow.after(tse)) {
                if (project.getPnm().equals(pt)) {
                    project.setPstate(2);
                } else {
                    project.setPstate(3);
                }
            }
            System.out.println("projectState = " + project.getPstate());
        } catch (NumberFormatException e) {
            System.out.println("输入内容有误");
            map.addAttribute("existaddprojectmsg", "true");
            map.addAttribute("addprojectmsg", "输入内容有误");
            return "updateproject.jsp";
        }


        boolean isok = projectBiz.update(project);
        if (isok) {
            session.setAttribute("addprojectid", project.getPid());
            map.addAttribute("msg", "修改项目成功,请上传图片");
            map.addAttribute("url", "upload.jsp");
            map.addAttribute("existaddprojectmsg", "false");
        } else {
            map.addAttribute("msg", "修改项目失败");
            map.addAttribute("url", "updateproject.jsp");
        }

        return "msg.jsp";
    }


    //project.jsp
    @RequestMapping(value = "ShowProject.mvc")
    public String project(HttpSession session, ModelMap map, String pid) {

        //检查用户是否有地址
        try {
            Users user = (Users) session.getAttribute("user");
            List<UsersAddress> addrlist = userBiz.findAllAddress(user.getUphone());
            if (addrlist == null || addrlist.size() == 0 || addrlist.get(0).getAddress() == null || addrlist.get(0).getAddress().equals("")) {
                session.setAttribute("mangetype","manageaddr()");
                return "redirect:manage.jsp?mangetype=manageaddr";
            } else {
                session.setAttribute("addr", addrlist);
            }
        } catch (Exception e) {
            session.setAttribute("mangetype","manageaddr()");
            return "redirect:manage.jsp?mangetype=manageaddr";
        }


        Project project = projectBiz.findProjectById(Integer.parseInt(pid));
        String pname = project.getPname();
        BigDecimal pnm = project.getPnm();
        int pnp = project.getPnp();
        Timestamp deadline = project.getPed();
        BigDecimal ptarget = project.getPtarget();
        String percentage = (pnm.divide(ptarget).multiply(BigDecimal.valueOf(Long.parseLong(100 + "")))).toString();


        //货币转换
        BigDecimal cpnm, cpt;
        cpnm = exchange.getValue(project.getPnm(), project.getPmf());
        cpt = exchange.getValue(project.getPtarget(), project.getPmf());

        String typestr = "人民币";
        switch (project.getPmf()) {
            case 1:
                typestr = "人民币";
                break;
            case 2:
                typestr = "美元";
                break;
            case 3:
                typestr = "欧元";
                break;
            case 4:
                typestr = "日元";
                break;
            case 5:
                typestr = "英镑";
                break;
        }


        map.addAttribute("cpnm", cpnm);
        map.addAttribute("cpt", cpt);
        map.addAttribute("typestr", typestr);

        map.addAttribute("showproject", project);

        map.addAttribute("percentage", percentage);

        //计算剩余时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        long difftime = deadline.getTime() - time.getTime();
        String timestr = "";
        if (difftime <= 0) {
            timestr = "已超过结束时间";
        } else {
            double dayDiff = Math.floor(difftime / (24 * 3600 * 1000));
            double leave1 = dayDiff % (24 * 3600 * 1000);
            double hours = Math.floor(leave1 / (3600 * 1000));//计算出小时数
            //计算相差分钟数
            double leave2 = leave1 % (3600 * 1000);    //计算小时数后剩余的毫秒数
            double minutes = Math.floor(leave2 / (60 * 1000));//计算相差分钟数
            //计算相差秒数
            double leave3 = leave2 % (60 * 1000);      //计算分钟数后剩余的毫秒数
            double seconds = Math.round(leave3 / 1000);
            timestr = "剩余" + dayDiff + "天 " + hours + "小时 " + minutes + " 分钟" + seconds + " 秒";
        }
        map.addAttribute("timestr", timestr);

        //将所有图片转为list
        List<ProjectImg> imglist = projectBiz.findimg(project.getPid());
        map.addAttribute("imglist", imglist);

        //评论
        List<ProjectComment> com = projectBiz.findcom(project.getPid());
        map.addAttribute("comlist", com);
        System.out.println("comlist = " + com.toString());

        String pathRoot = session.getServletContext().getRealPath("");
        String savePath = pathRoot + "/images/" + pid + "/";
        File countfile = new File(savePath);
        String[] files = countfile.list();
        int i = files.length;

        session.setAttribute("pid", pid);
        session.setAttribute("showproject", project);
        return "project.jsp";
    }


    @RequestMapping(value = "AddComment.mvc", method = RequestMethod.POST)
    public String AddComment(HttpSession session, ModelMap map, String newcom, String pid) {
        Project p = (Project) session.getAttribute("showproject");
        Users u = (Users) session.getAttribute("user");

        projectBiz.savecom(p, u, newcom);
        map.addAttribute("msg", "添加评论成功");
        map.addAttribute("url", "ShowProject.mvc?pid=" + p.getPid());
        return "msg.jsp";
    }

    @RequestMapping(value = "Projectlist.mvc")
    public String Projectlist(ModelMap map, HttpSession session, String type, String searchstr) {
        //Type:0 hot,1 new,2 most people,3 数码,4 生活,5 艺术,6 搜索

        int typeint = Integer.parseInt(type);
        List<Project> projectlist = null;

        String typestr = "";
        int typestrtype = 0;

        if (typeint == 6) {
            if (searchstr == null || searchstr.isEmpty()) {
                //搜索内容为空
                map.addAttribute("existpagemsg", "true");
                map.addAttribute("pagemsg", "请输入要搜索的内容");
                return "projectlist.jsp";
            }
        } else {
            map.addAttribute("existpagemsg", "false");
        }


        switch (typeint) {
            case 0:
                projectlist = projectBiz.findHotProject();
                typestr = "images/热门推荐.png";
                break;
            case 1:
                projectlist = projectBiz.findNewProject();
                typestr = "images/最新.png";
                break;
            case 2:
                projectlist = projectBiz.findMostProject();
                typestr = "images/最多.png";
                break;
            case 3:
                projectlist = projectBiz.findProject1();
                typestr = "images/数码.png";
                break;
            case 4:
                projectlist = projectBiz.findProject2();
                typestr = "images/生活.png";
                break;
            case 5:
                projectlist = projectBiz.findProject3();
                typestr = "images/艺术.png";
                break;
            case 6:
                projectlist = projectBiz.findProjectBySearch(searchstr);
                typestr = searchstr;
                typestrtype = 1;
                break;
        }
        session.setAttribute("projectlist", projectlist);
        session.setAttribute("projectlistAll", projectlist);
        session.setAttribute("typestrtype", typestrtype);
        session.setAttribute("typestr", typestr);
        session.setAttribute("countlist", projectlist.size());


        //显示的数量
        int pageShowNum = 8;
        session.setAttribute("pageShowNum", pageShowNum);
        if (projectlist.size() > pageShowNum) {
            //分页
            double psize = projectlist.size();
            double psn = pageShowNum;
            double pagesd = psize / psn;
            System.out.println(pagesd);
            int pages = (int) Math.ceil(pagesd);
            //总页数
            session.setAttribute("pages", pages);


            System.out.println("pages = " + pages);
            System.out.println("projectlist = " + projectlist.size());
            System.out.println("pageShowNum = " + pageShowNum);


            return "Projectlistpage.mvc?page=1";
        } else {
            session.setAttribute("nowpage", 1);
            session.setAttribute("pages", 1);
            return "projectlist.jsp";
        }
    }

    @RequestMapping(value = "Projectlistpage.mvc")
    public String Projectlistpage(HttpSession session, ModelMap map, String page) {
        int pageShowNum = (int) session.getAttribute("pageShowNum");
        int pages = (int) session.getAttribute("pages");
        map.addAttribute("existpagemsg", "true");

        //分页显示
        int pageint = 1;

        System.out.println("pages = " + pages);

        try {
            pageint = Integer.parseInt(page);
        } catch (Exception e) {
            map.addAttribute("pagemsg", "请输入页码");
            System.out.println("输入的不是页码,跳转第一页");
        }

        if (pageint < 1 || pageint > pages) {
            map.addAttribute("pagemsg", "请输入正确的页码");
            System.out.println("错误的页码,跳转第一页");
        } else {

            List<Project> projectlist = (List<Project>) session.getAttribute("projectlistAll");

            List<Project> projectlistpage = new ArrayList<>();

            int start = (pageint - 1) * pageShowNum;
            int end = (pageint) * pageShowNum;
            if (pageint == pages) {
                //最后一页
                end = projectlist.size();

            }

            System.out.println("start = " + start);
            System.out.println("end = " + end);

            for (int i = start; i < end; i++) {
                Project project = projectlist.get(i);
                System.out.println("pages: show i = " + i);
                System.out.println("project = " + project.getPid());
                projectlistpage.add(project);
            }

            //放入数据
            session.setAttribute("projectlist", projectlistpage);
            //当前是第几页
            session.setAttribute("nowpage", pageint);
            //ok
            map.addAttribute("existpagemsg", "false");
        }


        return "projectlist.jsp";
    }

}
