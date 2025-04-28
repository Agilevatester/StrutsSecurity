package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class SingleFileUploadAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private File upload;
    private String uploadFileName;
    private String uploadContentType;

    private HttpServletRequest request;
    private HttpServletResponse response;

    public String execute() {
        if (upload != null) {
            System.out.println("Uploaded file: " + uploadFileName);
            request.setAttribute("message", "File uploaded successfully: " + uploadFileName);
        } else {
            request.setAttribute("message", "No file uploaded.");
        }
        return SUCCESS;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}