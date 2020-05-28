package com.i.pro.config;

import com.i.pro.vo.ResponseBean;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
/**
 * 全局异常处理
 */
public class ControllerHandler {

    private static final Logger logger = Logger.getLogger(ControllerHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseBean handlerException(Exception e) {
        logger.error("handler redirect exception....");
        ResponseBean responseBean = new ResponseBean();
        responseBean.addError(404, e.getMessage());
        return responseBean;
    }
}
