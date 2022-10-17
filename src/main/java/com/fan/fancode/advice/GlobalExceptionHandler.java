package com.fan.fancode.advice;


import com.fan.fancode.common.exception.BusinessErrorException;
import com.fan.fancode.domain.entity.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理类
 * // @ControllerAdvice表示该类是Controller层的拦截器，Controller层的http请求都会拦截在这里进行统一处理
 * // @ResponseBody表示返回值为Json格式
 *
 * @author debug_fan
 * @date 2022/10/16 21:33
 **/

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 打印log
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * url参数请求缺少请求参数异常
     *
     * @param ex HttpMessageNotReadableException
     * @return jsonResult
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult<Object> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult<>(400, "缺少请求参数");
    }

    /**
     * json请求缺少请求参数异常
     *
     * @param ex HttpMessageNotReadableException
     * @return jsonResult
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult<Object> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult<>(400, "缺少请求参数");
    }

    /**
     * 空指针异常
     *
     * @param ex NullPointerException
     * @return jsonResult
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<Object> handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常，{}", ex.getMessage());
        return new JsonResult<>(500, "空指针异常了");
    }

    /**
     * 拦截业务异常，返回业务异常信息
     *
     * @param ex 自定义业务异常
     * @return jsonResult
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<Object> handleBusinessError(BusinessErrorException ex) {
        Integer code = ex.getCode();
        String msg = ex.getMsg();
        return new JsonResult<>(code, msg);
    }

    /**
     * 系统异常 预期以外异常
     *
     * @param ex Exception
     * @return jsonResult
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<Object> handleUnexpectedServer(Exception ex) {
        logger.error("系统异常：", ex);
        return new JsonResult<>(500, "系统发生异常，请联系管理员");
    }

}

