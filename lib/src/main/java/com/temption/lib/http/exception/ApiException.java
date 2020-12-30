package com.temption.lib.http.exception;

/**
 * api自定义Exception
 */
public class ApiException extends Exception {
    /**
     * 错误码
     */
    private int status;

    /**
     * 错误信息
     */
    private String message;

    public ApiException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}