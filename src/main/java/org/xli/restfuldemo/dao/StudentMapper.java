package org.xli.restfuldemo.dao;

import org.xli.restfuldemo.pojo.entity.StudentDO;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    StudentDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentDO record);

    int addStudentSelective(StudentDO record);
}
