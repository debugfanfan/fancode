package com.fan.fancode.web.controller;


import com.fan.fancode.common.exception.BusinessErrorException;
import com.fan.fancode.common.exception.BusinessMsgEnum;
import com.fan.fancode.domain.entity.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ExceptionController
 *
 * @author debug_fan
 * @date 2022/10/17 22:18
 **/
@RestController
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping("/exception/business")
    public JsonResult<Object> testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult<>();
    }
}

