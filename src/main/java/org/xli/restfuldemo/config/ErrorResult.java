package org.xli.restfuldemo.config;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/30 11:16
 */
public class ErrorResult {
    private int errorCode;
    private String errorMsg;

    public ErrorResult(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
