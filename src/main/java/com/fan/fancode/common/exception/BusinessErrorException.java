package com.fan.fancode.common.exception;


/**
 * 自定义业务异常
 *
 * @author debug_fan
 * @date 2022/10/17 21:34
 **/
public class BusinessErrorException extends RuntimeException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 消息码
     */
    private Integer code;
    /**
     * 消息内容
     */
    private String msg;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.getCode();
        this.msg = businessMsgEnum.getMsg();
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
}

