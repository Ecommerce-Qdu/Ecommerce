package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.*;
import com.niit.utils.SaveToWord;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private IUserBiz userBiz;

    @Autowired
    private IProjectBiz projectBiz;

    @Autowired
    private SaveToWord saveToWord;


    @RequestMapping(value = "Manage.mvc")
    public String manage(ModelMap map, HttpSession session) {
        System.out.println("Manage.mvc");
        Users user = (Users) session.getAttribute("user");

        String uphone = user.getUphone();
        System.out.println("uphone = " + uphone);


        List<Orders> myorders = userBiz.findAllOrder(user.getUphone());
        System.out.println("myorders = " + myorders.size());
        List<Project> mynewprojects = userBiz.findAllUserProject(user.getUphone());
        System.out.println("myorders = " + myorders.size());
        List<ProjectComment> mycomments = userBiz.findAllUserProjectComment(user.getUphone());
        System.out.println("myorders = " + myorders.size());


        session.setAttribute("myorders", myorders);
        session.setAttribute("mynewprojects", mynewprojects);
        session.setAttribute("mycomments", mycomments);


        return "manage.jsp";
    }

    @RequestMapping(value = "Changepwd.mvc")
    public String manage(ModelMap map, HttpSession session, String nowpwd, String newpwd, String newpwd2) {
        if (nowpwd == null || nowpwd == "" || newpwd == null || newpwd == "" || newpwd2 == null || newpwd2 == "") {
            map.addAttribute("msg", "请输入密码");
            map.addAttribute("url", "manage_person.jsp");
            return "msg.jsp";
        }
        Users user = (Users) session.getAttribute("user");
        String pwd = user.getUpwd();
        if (newpwd.equals(newpwd2) && pwd.equals(DigestUtils.md5Hex(nowpwd))) {
            boolean isok = userBiz.changepwd(user.getUphone(), DigestUtils.md5Hex(newpwd));
            if (isok) {
                map.addAttribute("msg", "修改密码成功");
                map.addAttribute("url", "Checkout.mvc");
            } else {
                map.addAttribute("msg", "修改密码失败");
                map.addAttribute("url", "manage_person.jsp");
            }
        } else {
            map.addAttribute("msg", "密码不一致");
            map.addAttribute("url", "manage_person.jsp");
        }
        return "msg.jsp";
    }

    @RequestMapping(value = "Changeinfo.mvc")
    public String Changeinfo(ModelMap map, HttpSession session, String uname,
                             String uZipCode, String uEmail, String uPhone) {
        System.out.println("new uname is :"+uname);
        Users user = (Users) session.getAttribute("user");
        String oldphone = user.getUphone();
        int type = user.getUtype();
        user.setUname(uname);
        user.setUphone(uPhone);
        System.out.println("user new is : "+user.toString());
        boolean isok = userBiz.update(user,oldphone);
        if (isok && (type == 2)) {
            UsersInfo usersInfo = user.getUsersInfoByUPhone();
            usersInfo.setUemail(uEmail);
            usersInfo.setUzipcode(uZipCode);
            isok = userBiz.updateinfo(usersInfo);
        }

        map.addAttribute("url", "manage_person.jsp");
        if (isok) {
            map.addAttribute("msg", "修改信息成功");
        } else {
            map.addAttribute("msg", "修改信息失败");

        }

        return "msg.jsp";
    }

    @RequestMapping(value = "ProjectDetails.mvc")
    public String ProjectDetails(ModelMap map, HttpSession session, String pid) {

        Project p = projectBiz.findProjectById(Integer.parseInt(pid));
        List<Orders> ordersList = userBiz.findOrderByPid(Integer.parseInt(pid));

        session.setAttribute("ProjectDetails", p);
        session.setAttribute("ProjectDetailsOrders", ordersList);


        return "manage_myprojectdetails.jsp";
    }

    @RequestMapping(value = "SaveToWord.mvc")
    public ModelAndView SaveToWord(ModelMap map, HttpSession session) throws IOException {

        Users user = (Users) session.getAttribute("user");
        List<Orders> myorders = userBiz.findAllOrder(user.getUphone());

        String uuid = saveToWord.createWord(myorders);

//        uuid = "redirect:file/" + uuid;
        uuid = "redirect:file/" + uuid;
        System.out.println("uuid = " + uuid);
        //不能直接return uuid,第一次跳转会失败
        return new ModelAndView(uuid);

    }
}
