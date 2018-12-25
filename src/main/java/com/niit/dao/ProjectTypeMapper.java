package com.niit.dao;

import com.niit.entity.ProjectType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeMapper {
    int deleteByPrimaryKey(Integer projecttypeid);

    int insert(ProjectType record);

    int insertSelective(ProjectType record);

    ProjectType selectByPrimaryKey(Integer projecttypeid);

    int updateByPrimaryKeySelective(ProjectType record);

    int updateByPrimaryKey(ProjectType record);
}