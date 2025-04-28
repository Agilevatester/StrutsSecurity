package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
    private String item;
    private int quantity;
    private String redirect;

    public String execute() {
        return SUCCESS;
    }

    public String confirm() {
        return SUCCESS;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}