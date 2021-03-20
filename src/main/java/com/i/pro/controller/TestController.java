package com.i.pro.controller;

import com.i.pro.service.interfaces.ITestSv;
import com.i.pro.vo.ResponseBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/q")
/**
 * 这里不用RestController，因为会让返回结果无法解析为视图
 * 还是用Controller,需要返回页面就返回页面，返回json就在方法上添加ResponseBody
 */
public class TestController {
    private static final Logger logger = Logger.getLogger(TestController.class);


    @Autowired
    private ITestSv testSv;

    @RequestMapping(path = "/qq", method = RequestMethod.GET)
    public String test() {
        logger.info("printing~~~~~~~~");
        return "/keyboardMapping";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String test1() {
        logger.info("printing~~~~~~~~");
        String result = testSv.hello();
        return result;
    }

    @GetMapping("/sayHi")
    @ResponseBody
    public ResponseBean test2() {
        ResponseBean responseBean = testSv.sayHi();
//        Integer.valueOf("qwe");
        return responseBean;
    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseBean test3() {
        logger.info("login in~");
        ResponseBean responseBean = new ResponseBean();
        responseBean.addSuccess("login in");
        return responseBean;
    }
}
