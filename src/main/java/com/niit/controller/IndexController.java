package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private IProjectBiz projectBiz;
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Index.mvc")
    public String findproject(HttpServletRequest request, ModelMap map, HttpSession session) {

        //检查用户是否记住登录状态
        String loginCookieUserName = "";
        String loginCookiePassword = "";

        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("loginUserName".equals(cookie.getName())) {
                    loginCookieUserName = cookie.getValue();
                } else if ("loginPassword".equals(cookie.getName())) {
                    loginCookiePassword = cookie.getValue();
                }
            }
            if (!"".equals(loginCookieUserName) && !"".equals(loginCookiePassword)) {
                Users user = userBiz.findUserByPhone(loginCookieUserName);
                if (user.getUflag()!=-1&&loginCookiePassword.equals(user.getUpwd())) {
                    request.getSession().setAttribute("user", user);
                }
            }
        }

        List<Project> hot = projectBiz.findHotProject();
        List<Project> newp = projectBiz.findNewProject();
        List<Project> p1 = projectBiz.findProject1();
        List<Project> p2 = projectBiz.findProject2();
        List<Project> p3 = projectBiz.findProject3();

        int counproject = projectBiz.countproject();
        int supportnum = projectBiz.supportnum();
        System.out.println("supportnum = " + supportnum);
        int countokpro = projectBiz.countokpro();

        map.addAttribute("counproject", counproject);
        map.addAttribute("supportnum", supportnum);
        map.addAttribute("countokpro", countokpro);

        map.addAttribute("ihot", hot);
        map.addAttribute("inewp", newp);
        map.addAttribute("ip1", p1);
        map.addAttribute("ip2", p2);
        map.addAttribute("ip3", p3);

        List<ProjectImg> hotimglist = projectBiz.findhotimg();
        System.out.println("hotimglist = " + hotimglist.size() + "\n" + hotimglist.toString());
//        List<ProjectImg> hotimglisttemp = null;
//        for (int i = 0; i < hot.size(); i++) {
//            Project project = hot.get(i);
//            hotimglist.add(project.getProjectImgList().get(0));
//
//        }
        session.setAttribute("hotimglist", hotimglist);
        session.setAttribute("hot", hot);

        return "index.jsp";
    }


}