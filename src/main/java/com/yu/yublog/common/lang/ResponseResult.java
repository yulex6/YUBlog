package com.yu.yublog.common.lang;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: zl-yu
 * @Date: 2022/9/18 11:52
 * @Description: 统一响应体
 */

public class ResponseResult<T> implements Serializable {
    /**响应码*/
    @ApiModelProperty("状态码")
    private Integer code;
    /**响应信息*/
    @ApiModelProperty("状态信息")
    private String message;
    /**具体数据*/
    @ApiModelProperty("返回数据")
    private T data;

    public ResponseResult() {}

    public ResponseResult(Code resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseResult(Code resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult(Code.SUCCESS);
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult(Code.SUCCESS,data);
        return result;
    }

    public static ResponseResult failure(Code resultCode) {
        ResponseResult result = new ResponseResult(resultCode);
        return result;
    }

    public static ResponseResult failure(Code resultCode, Object data) {
        ResponseResult result = new ResponseResult(resultCode,data);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
