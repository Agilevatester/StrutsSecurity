package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class VulnerableAction extends ActionSupport {
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String execute() throws Exception {
        // Simulate vulnerability by echoing user input
        addActionMessage("User input: " + input);
        return SUCCESS;
    }
}