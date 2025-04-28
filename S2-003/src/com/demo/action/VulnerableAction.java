package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class VulnerableAction extends ActionSupport {
    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String execute() throws Exception {
        // Simulate processing the command
        System.out.println("Executing command: " + command);
        return SUCCESS;
    }
}