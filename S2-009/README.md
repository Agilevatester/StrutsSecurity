# Exploiting S2-009 Vulnerability

## Overview
The S2-009 vulnerability in Apache Struts 2 allows attackers to execute arbitrary OGNL (Object-Graph Navigation Language) expressions. This vulnerability arises due to improper handling of user input in the `struts.devMode` configuration and dynamic method invocation.

## Steps to Exploit

1. **Setup the Environment**:
   - Deploy the vulnerable Struts 2 application (e.g., S2-009 module) on a servlet container like Apache Tomcat.
   - Ensure the required libraries are present in the `WEB-INF/lib` directory, including:
     - `struts2-core-2.0.8.jar`
     - `ognl-2.6.11.jar`
     - `xwork-2.0.3.jar`
     - `commons-logging-1.0.4.jar`

2. **Identify the Vulnerable Endpoint**:
   - Locate an action that processes user input, such as the `submitData` action in the `AjaxAction` class.
   - Ensure the `struts.devMode` is set to `true` in `struts.xml`.

3. **Craft the Exploit**:
   - Send a specially crafted HTTP request with malicious OGNL expressions in the parameters.
   - Example payload:
     ```
     curl -X POST -d "name=%{#context[\'xwork.MethodAccessor.denyMethodExecution\']=false,#_memberAccess[\'allowStaticMethodAccess\']=true,@java.lang.Runtime@getRuntime().exec('calc')}" -d "age=25" http://<target>/ajax/submitData.action
     ```

4. **Execute the Exploit**:
   - Observe the server's response and verify if the OGNL expression was executed.
   - For example, the above payload would attempt to execute the `calc` command on the server.

## Mitigation

To mitigate the S2-009 vulnerability:
- Upgrade to a patched version of Apache Struts 2.
- Disable `struts.devMode` in production environments.
- Use input validation and sanitization to prevent malicious input.

## Disclaimer
This information is provided for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.