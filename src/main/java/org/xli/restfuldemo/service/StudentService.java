package org.xli.restfuldemo.service;

import org.xli.restfuldemo.exception.ResourceAlreadyExistException;
import org.xli.restfuldemo.exception.ResourceNotExistException;
import org.xli.restfuldemo.pojo.entity.AddStudentDTO;
import org.xli.restfuldemo.pojo.entity.StudentDO;
import org.xli.restfuldemo.pojo.entity.StudentDTO;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/28 11:31
 */
public interface StudentService {
    void deleteStudentById(String id) throws ResourceNotExistException;

    void addStudentSelective(AddStudentDTO record) throws ResourceAlreadyExistException;

    StudentDO selectStudentById(String id) throws ResourceNotExistException;

    void updateStudentByIdSelective(StudentDTO record) throws ResourceNotExistException;
}
