package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersAddress;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Login.mvc")
    public String Login(HttpServletResponse response, String phone,
                        String username, String password, HttpServletRequest req,
                        HttpSession session, ModelMap map, String savepwd) {
        System.out.println("密码登录-----------------------------");
        if (phone == null || password == null) {
            map.addAttribute("msg", "手机或密码不能为空");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        Users user = userBiz.findUserByPhone(phone);

        try {
            if (!phone.equals(user.getUphone())) {
                map.addAttribute("msg", "该手机号未注册");
                map.addAttribute("msgtype", "login");
                return "lrf.jsp";
            }
        } catch (Exception e) {
            map.addAttribute("msg", "该手机号未注册");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        System.out.println("检查密码");
        if (user.getUpwd().equals(DigestUtils.md5Hex(password))) {
            System.out.println("密码正确");
            session.setAttribute("user", user);

            System.out.println("savepwd = " + savepwd);
            if (savepwd != null) {
                Cookie userNameCookie = new Cookie("loginUserName", user.getUphone());
                Cookie passwordCookie = new Cookie("loginPassword", user.getUpwd());
                userNameCookie.setMaxAge(604800);
                userNameCookie.setPath("/");
                passwordCookie.setMaxAge(604800);
                passwordCookie.setPath("/");
                response.addCookie(userNameCookie);
                response.addCookie(passwordCookie);
            }

            List<UsersAddress> list = userBiz.findAllAddress(user.getUphone());
            session.setAttribute("addr", list);
            if (list.size() == 0) {
                return "redirect:manage.jsp?mangetype=manageaddr";
            }
            if (user.getUtype() == 1) {
                return "Index.mvc";
            } else {
                return "redirect:Manage.mvc";
            }

        } else {
            map.addAttribute("msg", "密码错误");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

    }

    @RequestMapping(value = "LoginBySms.mvc", method = RequestMethod.POST)
    public String LoginBySms(String phone, String username, String sms, HttpServletRequest req, HttpSession session, ModelMap map) {
        System.out.println("验证码登录---------------------------");
        if (phone == null || sms == null) {
            map.addAttribute("msg", "手机或验证码不能为空");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        Users user = userBiz.findUserByPhone(phone);

        try {
            if (!phone.equals(user.getUphone())) {
                map.addAttribute("msg", "该手机号未注册");
                map.addAttribute("msgtype", "login");
                return "lrf.jsp";
            }
        } catch (Exception e) {
            map.addAttribute("msg", "该手机号未注册");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        System.out.println("sms = " + sms);
        System.out.println("user = " + req.getSession().getAttribute("code"));

        if (sms.equals(req.getSession().getAttribute("code").toString())) {
            System.out.println("验证码正确");
            session.setAttribute("user", user);

            List<UsersAddress> list = userBiz.findAllAddress(user.getUphone());
            session.setAttribute("addr", list);
            if (user.getUtype() == 1) {
                return "Index.mvc";
            } else {
                return "redirect:Manage.mvc";
            }

        } else {
            map.addAttribute("msg", "验证码错误");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

    }

    @RequestMapping(value = "Checkout.mvc", method = RequestMethod.GET)
    public String Checkout(HttpServletResponse response, HttpServletRequest req, HttpSession session, ModelMap map) {

        map.addAttribute("msg", "已注销");
        map.addAttribute("url", "Index.mvc");

        Users user = (Users) session.getAttribute("user");
        Cookie userNameCookie = new Cookie("loginUserName", user.getUphone());
        Cookie passwordCookie = new Cookie("loginPassword", user.getUpwd());
        userNameCookie.setMaxAge(0);
        userNameCookie.setPath("/");
        passwordCookie.setMaxAge(0);
        passwordCookie.setPath("/");
        response.addCookie(userNameCookie);
        response.addCookie(passwordCookie);
        req.getSession().invalidate();
        return "msg.jsp";
    }
}