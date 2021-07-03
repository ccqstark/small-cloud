package com.ccqstark.smallcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ccqstark
 * @description 通用返回结果
 * @date 2021/1/12 10:15 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 错误码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    /**
     * 无数据负载默认成功结果
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 默认成功结果,自定义数据负载
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 自定义信息成功结果
     */
    public static <T> CommonResult<T> success(String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, null);
    }

    /**
     * 自定义成功结果
     */
    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 自定义信息错误结果
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
        return new CommonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * 预定义错误结果
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 一般错误结果，自定义错误信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 默认一般错误结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized() {
        return failed(ResultCode.UNAUTHORIZED);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden() {
        return failed(ResultCode.FORBIDDEN);
    }

}
