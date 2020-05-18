package org.xli.restfuldemo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xli.restfuldemo.config.ErrorResult;
import org.xli.restfuldemo.config.ResponseResult;
import org.xli.restfuldemo.constant.ResponseType;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xli
 * @Description 统一异常处理器
 * @Date 创建于 2019/1/30 11:24
 */
@RestControllerAdvice
public class GlobalExceptionProcess extends ResponseEntityExceptionHandler {
    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ResponseResult> globalExceptionProcess(GlobalException e) {
        //可以通过日志记录一些信息
        return new ResponseEntity<>(ResponseResult.error(new ErrorResult(e.getCode(), e.getMessage())), HttpStatus.OK);
    }

    /**
     * 处理Bean Validation异常
     * @param e
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        // join错误消息列表
        List<String> errorMsgList = errors.stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        String msg = String.join(", ", errorMsgList);
        // 不需要返回400，这里返回200，前端根据errorCode自己处理
        return new ResponseEntity<>(ResponseResult.error(new ErrorResult(ResponseType.ERROR.code, msg)), HttpStatus.OK);
    }

    /**
     * 处理Bean Validation异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseResult> constraintExceptionProcess(ConstraintViolationException e) {
        // join错误消息列表
        List<String> errorMsgList = e.getConstraintViolations().stream()
                .map(v-> v.getMessage())
                .collect(Collectors.toList());
        String msg = String.join(", ", errorMsgList);

        return new ResponseEntity<>(ResponseResult.error(new ErrorResult(ResponseType.ERROR.code, msg)), HttpStatus.OK);
    }
}
