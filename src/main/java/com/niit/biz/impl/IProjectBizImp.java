package com.niit.biz.impl;

import com.niit.biz.IProjectBiz;
import com.niit.dao.OrdersMapper;
import com.niit.dao.ProjectCommentMapper;
import com.niit.dao.ProjectImgMapper;
import com.niit.dao.ProjectMapper;
import com.niit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class IProjectBizImp implements IProjectBiz {
    
    @Autowired
    private ProjectMapper projectDao;
    @Autowired
    private ProjectImgMapper projectImgDao;

    @Autowired
    private OrdersMapper iOrderDao;
    
    @Autowired
    private ProjectCommentMapper projectCommentDao;


    @Override
    public List<Project> findHotProject() {
        return projectDao.findHotProject();
    }

    @Override
    public List<Project> findNewProject() {
        return projectDao.findNewProject();
    }

    @Override
    public List<Project> findMostProject() {
         return projectDao.findMostProject();
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
        return projectDao.countproject();
    }

    @Override
    public int supportnum() {
        return projectDao.supportnum();
    }

    @Override
    public int countokpro() {
        return projectDao.countokpro();
    }

    @Override
    public List<ProjectImg> findimg(int pid) {
        return projectImgDao.findimg(pid);
    }

    @Override
    public List<ProjectImg> findhotimg() {
        return projectImgDao.findhotimg();
    }

    @Override
    public List<ProjectComment> findcom(Integer pid) {
        return projectCommentDao.findcom(pid);
    }

    @Override
    public List<Project> findProject1() {

        return projectDao.findProject1();
    }

    @Override
    public List<Project> findProject2() {

        return projectDao.findProject2();
    }

    @Override
    public List<Project> findProject3() {
            return projectDao.findProject3();
    }

    @Override
    public int save(Project project) {
        System.out.println(project.toString());
        projectDao.save(project);
        return project.getPid();
    }

    @Override
    public Project findProjectById(int pid) {
        return projectDao.findProjectById(pid);
    }

    @Override
    public int saveimg(int pid, List<String> listImagePath) {
        return projectImgDao.saveimg(pid, listImagePath);
    }

    @Override
    public boolean savecom(Project p, Users u, String newcom) {
        return projectCommentDao.savecom(p, u, newcom);
    }


}
