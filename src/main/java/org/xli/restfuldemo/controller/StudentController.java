package org.xli.restfuldemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.xli.restfuldemo.exception.ResourceAlreadyExistException;
import org.xli.restfuldemo.exception.ResourceNotExistException;
import org.xli.restfuldemo.config.ResponseResult;
import org.xli.restfuldemo.pojo.entity.AddStudentDTO;
import org.xli.restfuldemo.pojo.entity.StudentDO;
import org.xli.restfuldemo.pojo.entity.StudentDTO;
import org.xli.restfuldemo.service.StudentService;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/28 11:06
 */
@Api(value = "Student用户的请求控制器")
@RestController
@RequestMapping("/students")
//@Validated
public class StudentController {
    @Autowired
    private StudentDTO.StudentValidator studentValidator;

    @Autowired
    private StudentService studentServiceImpl;

    @Autowired
    private Validator globalValidator;

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", required = true, paramType = "path")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseResult> getStudentById(@PathVariable(name = "id") String id) throws ResourceNotExistException {
        StudentDO student = studentServiceImpl.selectStudentById(id);
        return new ResponseEntity<>(ResponseResult.success(student), HttpStatus.OK);
    }

    @ApiOperation(value = "增加用户信息", notes = "根据Student实体类新增用户信息")
    @ApiImplicitParam(name = "student", value = "用户信息实体类", dataType = "AddStudentDTO", required = true, paramType = "body")
    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseResult> addStudent(@Validated @RequestBody AddStudentDTO student) throws ResourceAlreadyExistException {
        studentServiceImpl.addStudentSelective(student);
        return new ResponseEntity<>(ResponseResult.success(), HttpStatus.OK);
    }

    @ApiOperation(value = "删除用户信息", notes = "根据用户id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", required = true, paramType = "path")
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseResult> deleteStudentById(@PathVariable String id) throws ResourceNotExistException {
        studentServiceImpl.deleteStudentById(id);
        return new ResponseEntity<>(ResponseResult.success(), HttpStatus.OK);
    }


    @ApiOperation(value = "修改用户信息", notes = "根据Student实体类修改用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", required = true, paramType = "path"),
        @ApiImplicitParam(name = "student", value = "用户信息实体类", dataType = "StudentDTO", required = true, paramType = "body")
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponseResult> updateStudentById(
            @PathVariable @Length(max = 8, message = "id长度不能大于8") @NotNull String id,
            @Validated(StudentDTO.Edit.class) @RequestBody StudentDTO student
    ) throws ResourceNotExistException {
//        Set<ConstraintViolation<StudentDTO>> set = globalValidator.validate(student, StudentDTO.Edit.class);
//        System.out.println(String.join(",", set.stream()
//                .map(e-> e.getMessage())
//                .collect(Collectors.toList())
//        ));
        student.setId(id);
        studentServiceImpl.updateStudentByIdSelective(student);
        return new ResponseEntity<>(ResponseResult.success(), HttpStatus.OK);
    }

    // 绑定自定义校验器
    @InitBinder
    public void validatorBinding(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(studentValidator);
    }
}
