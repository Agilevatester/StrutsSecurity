# CVE-2017-9791 (S2-048)

## Description
CVE-2017-9791 is a Remote Code Execution (RCE) vulnerability in Apache Struts 2. It affects applications using the Struts 1 plugin in the Struts 2.3.x series. The issue arises when untrusted input is used as part of an error message in the `ActionMessage` class. This allows attackers to execute arbitrary code by injecting malicious field values.

## How This Application Demonstrates the Vulnerability
This project replicates the S2-048 vulnerability by:
1. Using the Struts 1 plugin in a Struts 2.3.x environment.
2. Including a Struts 1 action that processes user input.
3. Passing untrusted input directly into an `ActionMessage` without proper sanitization.

When the application is deployed and accessed, an attacker can exploit the vulnerability by crafting a malicious request that injects executable code into the error message. This demonstrates the potential impact of the vulnerability in a controlled environment.

## Usage Instructions
1. Build the project using Maven: `mvn clean package`.
2. Deploy the generated WAR file to a servlet container (e.g., Apache Tomcat).
3. Access the application and simulate an attack by sending a crafted request to the vulnerable endpoint.

## Mitigation
To mitigate this vulnerability, always use resource keys instead of passing raw messages to the `ActionMessage` class. Avoid using untrusted input directly in error messages.