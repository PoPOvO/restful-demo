package org.xli.restfuldemo.constant;

/**
 * @author xli
 * @Description 响应结果类型
 * @Date 创建于 2019/1/30 16:39
 */
public enum ResponseType {
    OK(1, "成功"),
    ERROR(0, "失败");

    public int code;
    public String message;

    ResponseType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
