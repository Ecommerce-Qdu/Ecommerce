package com.niit.dao;

import com.niit.entity.Project;
import com.niit.entity.ProjectComment;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> findAllUserProject(String s);

    List<ProjectComment> findAllUserProjectComment(String s);

    List<Project> findHotProject();

    List<Project> findNewProject();

    List<Project> findMostProject();

    List<Project> findProjectBySearch(String searchstr);

    boolean update(Project project);

    int countproject();

    int supportnum();

    int countokpro();

    List<ProjectImg> findimg(int pid);



    List<Project> findProject1();

    List<Project> findProject2();

    List<Project> findProject3();

    int save(Project project);

    Project findProjectById(int pid);

    boolean saveimg(int pid, List<String> listImagePath);
    
}