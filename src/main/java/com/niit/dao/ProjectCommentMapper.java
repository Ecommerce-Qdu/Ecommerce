package com.niit.dao;

import com.niit.entity.Project;
import com.niit.entity.ProjectComment;
import com.niit.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectCommentMapper {
    int deleteByPrimaryKey(Integer pcid);

    int insert(ProjectComment record);

    int insertSelective(ProjectComment record);

    ProjectComment selectByPrimaryKey(Integer pcid);

    int updateByPrimaryKeySelective(ProjectComment record);

    int updateByPrimaryKey(ProjectComment record);

    List<ProjectComment> findAllUserProjectComment(String s);
    
    boolean savecom(Project p, Users u, String newcom);

    List<ProjectComment> findcom(Integer pid);
}