# Struts2 Vulnerable Application - CVE-2017-7672

## Overview
This project demonstrates the Apache Struts2 vulnerability CVE-2017-7672, which allows a potential Denial of Service (DoS) attack when using the `URLValidator` class. The vulnerability arises from the ability to overload the server process by providing specially crafted URLs during validation.

## Vulnerability Details
- **CVE ID**: CVE-2017-7672
- **Description**: The vulnerability is caused by improper handling of URLs in the `URLValidator` class. An attacker can exploit this by submitting a specially crafted URL that consumes excessive server resources during validation, leading to a Denial of Service (DoS) condition.
- **Affected Versions**: Struts 2.3.5 to 2.3.33 and 2.5 to 2.5.12.

## Demonstration
This application is configured with Struts2 and includes a feature to validate user-provided URLs. The following steps demonstrate the vulnerability:

1. **Setup**:
   - Build the application using Maven: `mvn clean package`.
   - Deploy the generated WAR file to a servlet container (e.g., Apache Tomcat).

2. **URL Validation Feature**:
   - Access the URL validation form at `http://<server>:<port>/S2-047/index.jsp`.
   - Enter a URL in the form and submit it for validation.

3. **Exploit**:
   - Submit a specially crafted URL designed to overload the server process. For example:
     ```
     http://<server>:<port>/S2-047/validateURL.action?url=http://[long-string-of-characters]
     ```
   - Observe the server's response time and resource usage to confirm the DoS condition.

## Mitigation
To protect against this vulnerability:
- Upgrade to Struts2 version 2.3.34 or later.
- Avoid using the `URLValidator` class for untrusted input.
- Implement input validation and rate-limiting mechanisms to prevent abuse.

## Disclaimer
This project is for educational purposes only. Do not use it in production environments or for malicious purposes.