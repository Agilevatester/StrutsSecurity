package com.demo.action;


import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport {
    private String message = null;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
