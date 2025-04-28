package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class UserInfoAction extends ActionSupport implements SessionAware {
    private String name;
    private String email;
    private Map<String, Object> session;

    public String execute() {
        session.put("name", name);
        session.put("email", email);
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}