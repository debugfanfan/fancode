package com.fan.fancode.common.exception;


/**
 * 业务异常提示信息枚举类
 *
 * @author debug_fan
 * @date 2022/10/17 21:25
 **/
public enum BusinessMsgEnum {
    // 参数异常
    PARAMETER_BIG_EXCEPTION_EXCEPTION(102, "参数异常!"),
    // 等待超时
    SERVICE_TIME_OUT(103, "服务调用超时！"),
    // 参数过大
    PARAMETER_BIG_EXCEPTION(102, "输入的图片数量不能超过50张!"),
    // 500 : 一劳永逸的提示也可以在这定义
    UNEXPECTED_EXCEPTION(500, "系统发生异常，请联系管理员！");
    // 还可以定义更多的业务异常

    /**
     * 消息码
     */
    private Integer code;
    /**
     * 消息内容
     */
    private String msg;

    BusinessMsgEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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

