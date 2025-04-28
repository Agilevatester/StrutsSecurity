package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class VulnerableAction extends ActionSupport {
    private String input;

    public String execute() {
        // No validation or sanitization of input
        return SUCCESS;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}