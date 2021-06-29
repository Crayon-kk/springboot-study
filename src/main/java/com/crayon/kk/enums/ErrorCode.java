package com.crayon.kk.enums;

/**
 * 错误类
 */
public enum ErrorCode {
    SUCCESS_CODE(0,"成功"),
    PARAM_ERROR_CODE(40001, "系统参数错误");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String error(int code) {
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.code == code) {
                return value.getMessage();
            }
        }

        return null;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
