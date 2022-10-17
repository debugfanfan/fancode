package com.fan.fancode.domain.entity;


/**
 * 统一返回值
 *
 * @author debug_fan
 * @date 2022/10/15 16:13
 **/
public class JsonResult<T> {

    /**
     * 消息码
     */
    private Integer code;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public JsonResult() {

        this.code = 0;
        this.msg = "操作成功！";
    }

    public JsonResult(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(String msg, T data) {
        this.code = 0;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

