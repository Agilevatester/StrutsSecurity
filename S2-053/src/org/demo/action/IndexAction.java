package org.demo.action;
import com.opensymphony.xwork2.ActionSupport;

// S2-053: Struts 2 Remote Code Execution Vulnerability
public class IndexAction
extends ActionSupport {
    public String name = "VulApps";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() {
        return "SUCCESS";
    }
}
