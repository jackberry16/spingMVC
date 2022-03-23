package com.chengh.spingmvc;

/**
 * 错误码枚举
 */
public enum ResultCode {
    SUCCESS("0", "success"),
    UNKNOWN_ERROR("1", "unknown error");

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
