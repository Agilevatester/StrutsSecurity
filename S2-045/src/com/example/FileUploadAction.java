package com.example;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class FileUploadAction extends ActionSupport {
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    public String execute() {
        try {
            File destFile = new File("uploads", uploadFileName);
            FileUtils.copyFile(upload, destFile);
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}