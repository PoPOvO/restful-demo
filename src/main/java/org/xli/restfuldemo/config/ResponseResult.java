package org.xli.restfuldemo.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.xli.restfuldemo.constant.ResponseType;

/**
 * @author xli
 * @Description 所有响应的实体类
 * @Date 创建于 2019/1/30 16:21
 */
@ApiModel("所有响应的实体类")
public class ResponseResult<T> {
    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private int code;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String message;

    /**
     * 响应的数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    private ResponseResult() {}

    /**
     * 成功响应，但无响应数据。
     */
    public static ResponseResult success() {
        return success("");
    }

    /**
     * 错误响应，单无响应数据。
     */
    public static ResponseResult error() {
        return error("");
    }

    /**
     * 成功响应，存在响应数据。
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult<T>()
                .setCode(ResponseType.OK.code)
                .setMessage(ResponseType.OK.message)
                .setData(data);
    }

    /**
     * 错误响应，存在响应数据。
     */
    public static <T> ResponseResult error(T data) {
        return new ResponseResult<T>()
                .setCode(ResponseType.ERROR.code)
                .setMessage(ResponseType.ERROR.message)
                .setData(data);
    }

    public T getData() {
        return data;
    }

    public ResponseResult setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult setCode(int code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
