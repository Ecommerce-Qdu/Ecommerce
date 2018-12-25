package com.niit.biz.impl;

import com.niit.biz.IProjectBiz;
import com.niit.dao.OrdersMapper;
import com.niit.dao.ProjectMapper;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProjectBizImp implements IProjectBiz {

    @Autowired
    private ProjectMapper projectDao;


    @Autowired
    private OrdersMapper iOrderDao;


    @Override
    public List<Project> findHotProject() {
        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;
//        return projectDao.findHotProject();
    }

    @Override
    public List<Project> findNewProject() {
        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;
//        return projectDao.findNewProject();
    }

    @Override
    public List<Project> findMostProject() {
        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;

//        return projectDao.findMostProject();
    }

    @Override
    public boolean saveorder(Orders o) {
        return iOrderDao.saveorder(o);
    }

    @Override
    public List<Project> findProjectBySearch(String searchstr) {
        return projectDao.findProjectBySearch(searchstr);
    }

    @Override
    public boolean update(Project project) {
        return projectDao.update(project);
    }

    @Override
    public int countproject() {
        return 1;
//        return projectDao.countproject();
    }

    @Override
    public int supportnum() {
        return 1;
//        return projectDao.supportnum();
    }

    @Override
    public int countokpro() {

        return 1;
//        return projectDao.countokpro();
    }

    @Override
    public List<ProjectImg> findimg(int pid) {
        return projectDao.findimg(pid);
    }

    @Override
    public List<ProjectImg> findhotimg() {
        return  new ArrayList<>();
//        return projectDao.findhotimg();
    }

    @Override
    public List<Project> findProject1() {

        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;
//        return projectDao.findProject1();
    }

    @Override
    public List<Project> findProject2() {
        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;

//        return projectDao.findProject2();
    }

    @Override
    public List<Project> findProject3() {
        Project p1 = new Project();
        p1.setPid(1);
        p1.setPname("1");
        p1.setPcategoryid(1);

        List<Project> pl1= new ArrayList<>();
        pl1.add(p1);

        return  pl1;

//        return projectDao.findProject3();
    }

    @Override
    public int save(Project project) {
        return projectDao.save(project);
    }

    @Override
    public Project findProjectById(int pid) {
        return projectDao.findProjectById(pid);
    }

    @Override
    public boolean saveimg(int pid, List<String> listImagePath) {
        return projectDao.saveimg(pid, listImagePath);
    }

    @Override
    public boolean savecom(Project p, Users u, String newcom) {
        return projectDao.savecom(p, u, newcom);
    }


}
