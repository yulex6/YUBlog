package com.yu.yublog.common.lang;

/**
 * @Author: zl-yu
 * @Date: 2022/9/18 11:47
 * @Description: 全局状态码
 */
public enum Code {
    //全局状态码
    SUCCESS(0,"操作成功！"),
    INVALID_PARAM(10003,"非法参数！"),
    FAIL(11111,"操作失败！"),
    UNAUTHENTICATED(10001,"此操作需要登陆系统！"),
    UNAUTHORISE(10002,"权限不足，无权操作！"),
    SERVER_ERROR(99999,"抱歉，系统繁忙，请稍后重试！"),
    LOGIN_SUCCESS(00000,"登录成功！"),
    LOGIN_ERROR(10000,"用户信息有误！");

    //操作代码
    int code;
    //提示信息
    String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String message() {
        return message;
    }

    public Integer code() {
        return code;
    }

    /**
     * 根据
     * @param name
     * @return
     */
    public static String getMessage(String name) {
        for (Code item : Code.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (Code item : Code.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return this.name();
    }


}
