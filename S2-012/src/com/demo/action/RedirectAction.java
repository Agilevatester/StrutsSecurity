package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport {
    private String redirectParam;

    public String getRedirectParam() {
        return redirectParam;
    }

    public void setRedirectParam(String redirectParam) {
        this.redirectParam = redirectParam;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}