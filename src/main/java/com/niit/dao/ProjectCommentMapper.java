package com.niit.dao;

import com.niit.entity.ProjectComment;
import org.springframework.stereotype.Repository;

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
}