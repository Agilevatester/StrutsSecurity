package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class DashboardAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public String execute() {
        if (session.containsKey("username")) {
            return SUCCESS;
        } else {
            return LOGIN;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}