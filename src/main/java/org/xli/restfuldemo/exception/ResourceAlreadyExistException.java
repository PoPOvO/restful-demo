package org.xli.restfuldemo.exception;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/30 11:04
 */
public class ResourceAlreadyExistException extends GlobalException {
    public ResourceAlreadyExistException(String message, int code) {
        super(message, code);
    }
}
