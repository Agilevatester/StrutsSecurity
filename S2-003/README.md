# Struts 2 S2-003 and S2-005 Vulnerable Application

This directory contains a vulnerable Struts 2 application designed to demonstrate the ParametersInterceptor Remote Command Execution (RCE) vulnerabilities: CVE-2010-1870 (S2-003) and CVE-2008-6504 (S2-005).

## Vulnerability Overview

### CVE-2010-1870 (S2-003)
The ParametersInterceptor RCE vulnerability allows attackers to execute arbitrary commands on the server by injecting malicious OGNL (Object-Graph Navigation Language) expressions into HTTP parameters. This vulnerability is present in Struts 2 versions prior to 2.0.9.

### CVE-2008-6504 (S2-005)
This vulnerability arises from improper handling of OGNL expressions in the `ParametersInterceptor`. It allows attackers to inject and execute arbitrary OGNL expressions via HTTP parameters. This issue is also present in Struts 2 versions prior to 2.0.9.

## Proof of Concept (PoC)

### Steps to Exploit CVE-2010-1870 (S2-003)
1. **Setup the Application**:
   - Deploy the vulnerable application to a servlet container like Apache Tomcat.
   - Ensure the required libraries (e.g., `struts2-core-2.0.8.jar`) are present in the `WEB-INF/lib` directory.

2. **Access the Vulnerable Endpoint**:
   - Navigate to the vulnerable endpoint, such as `/vulnerable.action`.

3. **Craft the Payload**:
   - Use a malicious OGNL expression as an HTTP parameter. For example:
     ```
     vulnerable.action?command=%23context[\'xwork.MethodAccessor.denyMethodExecution\']=false&%23_memberAccess[\'allowStaticMethodAccess\']=true&%23a=@java.lang.Runtime@getRuntime().exec('calc')
     ```
   - Replace `calc` with the desired command to execute on the server.

4. **Execute the Payload**:
   - Send the crafted payload using a browser, curl, or a tool like Burp Suite.

5. **Observe the Result**:
   - Check the server logs or the application response to confirm the command execution.

### Steps to Exploit CVE-2008-6504 (S2-005)
1. **Setup the Application**:
   - Deploy the vulnerable application to a servlet container like Apache Tomcat.
   - Ensure the required libraries (e.g., `struts2-core-2.0.8.jar`) are present in the `WEB-INF/lib` directory.

2. **Access the Vulnerable Endpoint**:
   - Navigate to the vulnerable endpoint, such as `/vulnerable.action`.

3. **Craft the Payload**:
   - Use a malicious OGNL expression as an HTTP parameter. For example:
     ```
     vulnerable.action?command=%23_memberAccess[\'allowStaticMethodAccess\']=true&%23a=@java.lang.Runtime@getRuntime().exec('calc')
     ```
   - Replace `calc` with the desired command to execute on the server.

4. **Execute the Payload**:
   - Send the crafted payload using a browser, curl, or a tool like Burp Suite.

5. **Observe the Result**:
   - Check the server logs or the application response to confirm the command execution.

## Mitigation
To mitigate these vulnerabilities, upgrade to Struts 2.0.9 or later, where the `ParametersInterceptor` has been patched to prevent OGNL injection.

## Disclaimer
This project is for educational purposes only. Do not use it for unauthorized testing or exploitation. The authors are not responsible for any misuse of this code.