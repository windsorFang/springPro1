package com.i.pro.vo;

import java.io.Serializable;

public class HelloVo implements Serializable {

    private static final long serialVersionUID = 9214142271549437468L;

    public HelloVo(String s) {
        this.hello = s;
    }

    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
