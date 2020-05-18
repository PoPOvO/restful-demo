package org.xli.restfuldemo.constant;

/**
 * @author xli
 * @Description 错误类型
 * @Date 创建于 2019/1/30 11:22
 */
public enum ErrorType {
    ResourceNotExist(1000, "资源不存在"),
    ResourceAlreadyExist(1001, "资源已经存在");

    public int code;
    public String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
