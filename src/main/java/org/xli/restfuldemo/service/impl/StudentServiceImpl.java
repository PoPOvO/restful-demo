package org.xli.restfuldemo.service.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xli.restfuldemo.dao.StudentMapper;
import org.xli.restfuldemo.constant.ErrorType;
import org.xli.restfuldemo.exception.ResourceAlreadyExistException;
import org.xli.restfuldemo.exception.ResourceNotExistException;
import org.xli.restfuldemo.pojo.entity.AddStudentDTO;
import org.xli.restfuldemo.pojo.entity.StudentDO;
import org.xli.restfuldemo.pojo.entity.StudentDTO;
import org.xli.restfuldemo.service.StudentService;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/28 11:33
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MapperFacade orikaMapperFacade;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteStudentById(String id) throws ResourceNotExistException {
        if (studentMapper.deleteByPrimaryKey(id) <= 0) {
            throw new ResourceNotExistException(ErrorType.ResourceNotExist.message, ErrorType.ResourceNotExist.code);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStudentSelective(AddStudentDTO record) throws ResourceAlreadyExistException {
        StudentDO student = orikaMapperFacade.map(record, StudentDO.class);
        if (studentMapper.addStudentSelective(student) <= 0) {
            throw new ResourceAlreadyExistException(ErrorType.ResourceAlreadyExist.message, ErrorType.ResourceAlreadyExist.code);
        }
    }

    @Override
    public StudentDO selectStudentById(String id) throws ResourceNotExistException {
        StudentDO student = studentMapper.selectByPrimaryKey(id);
        if (student == null) {
            throw new ResourceNotExistException(ErrorType.ResourceNotExist.message, ErrorType.ResourceNotExist.code);
        }
        return student;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateStudentByIdSelective(StudentDTO record) throws ResourceNotExistException {
        StudentDO student = orikaMapperFacade.map(record, StudentDO.class);
        if (studentMapper.updateByPrimaryKeySelective(student) <= 0 && studentMapper.selectByPrimaryKey(record.getId()) == null) {
            throw new ResourceNotExistException(ErrorType.ResourceNotExist.message, ErrorType.ResourceNotExist.code);
        }
    }
}
