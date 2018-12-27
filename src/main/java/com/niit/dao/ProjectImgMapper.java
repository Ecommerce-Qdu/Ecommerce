package com.niit.dao;

import com.niit.entity.ProjectImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(ProjectImg record);

    int insertSelective(ProjectImg record);

    ProjectImg selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(ProjectImg record);

    int updateByPrimaryKey(ProjectImg record);

    List<ProjectImg> findhotimg();

    List<ProjectImg> findimg(int pid);
    
    int saveimg(int pid,List<String> path);
}