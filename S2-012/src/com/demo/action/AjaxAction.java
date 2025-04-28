package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.demo.UserData;

public class AjaxAction extends ActionSupport implements ModelDriven<UserData> {
    private UserData userData = new UserData();

    @Override
    public UserData getModel() {
        return this.userData;
    }

    @Override
    public String execute() {
        // Process the data (e.g., validation or business logic)
        if (userData.getName() == null || userData.getAge() == null) {
            return ERROR;
        }
        return SUCCESS;
    }
}