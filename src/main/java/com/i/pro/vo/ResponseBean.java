package com.i.pro.vo;

import java.io.Serializable;

public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = -1581307735801597846L;

    private String msg = "success";

    private int code = 200;

    private T data;

    public void addSuccess(T data) {
        this.msg = "success";
        this.code = 200;
        this.data = data;
    }

    public void addError(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseBean<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseBean<T> setData(T data) {
        this.data = data;
        return this;
    }
}
