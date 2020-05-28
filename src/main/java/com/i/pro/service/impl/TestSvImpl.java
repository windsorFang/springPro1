package com.i.pro.service.impl;

import com.i.pro.service.interfaces.ITestSv;
import com.i.pro.vo.HelloVo;
import com.i.pro.vo.ResponseBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TestSvImpl implements ITestSv {

    private static final Logger logger = Logger.getLogger(TestSvImpl.class);

    public String hello() {
        logger.info("hello in service~");
        return "hello in service";
    }

    @Override
    public ResponseBean sayHi() {
        ResponseBean responseBean = new ResponseBean<>();
        responseBean.addSuccess(new HelloVo("say hi"));
        return responseBean;
    }
}
