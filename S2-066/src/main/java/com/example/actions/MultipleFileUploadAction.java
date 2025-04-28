package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public class MultipleFileUploadAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private List<File> uploads;
    private List<String> uploadFileNames;
    private List<String> uploadContentTypes;

    private HttpServletRequest request;
    private HttpServletResponse response;

    public String execute() {
        if (uploads != null && !uploads.isEmpty()) {
            for (String fileName : uploadFileNames) {
                System.out.println("Uploaded file: " + fileName);
            }
            request.setAttribute("message", "Files uploaded successfully: " + uploadFileNames);
        } else {
            request.setAttribute("message", "No files uploaded.");
        }
        return SUCCESS;
    }

    public void setUploads(List<File> uploads) {
        this.uploads = uploads;
    }

    public void setUploadFileNames(List<String> uploadFileNames) {
        this.uploadFileNames = uploadFileNames;
    }

    public void setUploadContentTypes(List<String> uploadContentTypes) {
        this.uploadContentTypes = uploadContentTypes;
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