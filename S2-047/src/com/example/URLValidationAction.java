package com.example;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidationAction extends ActionSupport {
    private String url;

    public String execute() {
        // Regular expression to check if the URL starts with http, https, ftp, or ftps
        String regex = "^(https?|ftps?)://.*$";
        if (url != null && Pattern.matches(regex, url)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}