package org.xli.restfuldemo.exception;

/**
 * @author xli
 * @Description 自定义全局异常
 * @Date 创建于 2019/1/30 11:00
 */
public class GlobalException extends Exception {
    private int code;

    public GlobalException() {
    }

    public GlobalException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
