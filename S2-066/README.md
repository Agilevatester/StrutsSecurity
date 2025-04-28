# S2-066 Vulnerable Application

This project demonstrates the CVE-2023-50164 vulnerability in Apache Struts2, specifically related to file upload functionality. The application includes both single and multiple file upload features, which are vulnerable to exploitation due to improper validation and handling of uploaded files.

## Vulnerability Details

CVE-2023-50164 is a critical vulnerability in Apache Struts2 that allows attackers to execute arbitrary code by exploiting the file upload mechanism. The vulnerability arises from insufficient validation of file upload parameters and improper handling of file content.

### Affected Code

#### Single File Upload
The `SingleFileUploadAction` class processes single file uploads without proper validation:

```java
public class SingleFileUploadAction extends ActionSupport {
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    public String execute() {
        // Vulnerable code: No validation of file type or content
        System.out.println("Uploaded file: " + uploadFileName);
        return SUCCESS;
    }

    // Getters and setters...
}
```

#### Multiple File Upload
The `MultipleFileUploadAction` class processes multiple file uploads and is similarly vulnerable:

```java
public class MultipleFileUploadAction extends ActionSupport {
    private List<File> uploads;
    private List<String> uploadsContentType;
    private List<String> uploadsFileName;

    public String execute() {
        // Vulnerable code: No validation of file types or content
        for (String fileName : uploadsFileName) {
            System.out.println("Uploaded file: " + fileName);
        }
        return SUCCESS;
    }

    // Getters and setters...
}
```

## How to Exploit

1. Deploy the application on a server.
2. Navigate to the single or multiple file upload pages.
3. Upload a malicious file to exploit the vulnerability.

## Demonstrating the Vulnerability

### Single File Upload Vulnerability
1. Navigate to the [Single File Upload](http://localhost:8080/S2-066/singleFileUpload.jsp) page.
2. Upload a file with malicious content (e.g., a script or executable file).
3. Observe that the file is accepted without validation, and its details are logged on the server.

### Multiple File Upload Vulnerability
1. Navigate to the [Multiple File Upload](http://localhost:8080/S2-066/multipleFileUpload.jsp) page.
2. Upload multiple files, including malicious files.
3. Observe that all files are accepted without validation, and their details are logged on the server.

These vulnerabilities demonstrate the lack of proper validation and sanitization in the file upload functionality, making the application susceptible to attacks.

## Mitigation

To mitigate this vulnerability, ensure proper validation of file types, sizes, and content. Use libraries or frameworks that provide secure file upload mechanisms and sanitize all user inputs.

## Disclaimer

This application is for educational purposes only. Do not use it in a production environment or for malicious purposes.