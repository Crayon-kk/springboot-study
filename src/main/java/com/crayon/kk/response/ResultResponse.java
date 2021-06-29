package com.crayon.kk.response;


import com.crayon.kk.enums.ErrorCode;

/**
 * @author 75510
 */
public class ResultResponse<T> extends BaseResponse<T> {

    public static <T> ResultResponse<T> success(T data) {
        ResultResponse<T> success = success();
        success.setData(data);
        return success;
    }

    public static <T> ResultResponse<T> success() {
        ResultResponse<T> response = new ResultResponse<>();
        response.setCode(ErrorCode.SUCCESS_CODE.getCode());
        response.setMsg(ErrorCode.SUCCESS_CODE.getMessage());
        return response;
    }

    public static <T> ResultResponse<T> error(ErrorCode errorCode) {
        ResultResponse<T> response = new ResultResponse<>();
        response.setCode(errorCode.getCode());
        response.setMsg(errorCode.getMessage());
        return response;
    }


}
