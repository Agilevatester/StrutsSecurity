# S2-013 Vulnerability Demonstration

## Overview
This application demonstrates the Apache Struts 2 vulnerability identified as **CVE-2013-1966** (S2-013). The vulnerability arises when the `s:url` or `s:a` tags are used with the `includeParams` attribute set to `all`. This allows request parameters to be included in the generated URL, potentially enabling the injection of malicious OGNL (Object-Graph Navigation Language) expressions.

## When the Vulnerability is Applicable
The vulnerability is applicable under the following conditions:
1. **Dynamic Method Invocation Enabled**:
   - The `struts.enable.DynamicMethodInvocation` constant is set to `true` in the `struts.xml` file.
2. **Use of `s:url` or `s:a` Tags with `includeParams="all"`**:
   - These tags include all request parameters (GET and POST) in the generated URL.
3. **Untrusted User Input**:
   - Malicious users can craft requests with specially crafted parameters containing OGNL expressions.

## How the Vulnerability is Exploited
1. A malicious user sends a request with a parameter containing an OGNL expression, such as:
   ```
   ?username=%{#context[\'xwork.MethodAccessor.denyMethodExecution\']=false,#_memberAccess[\'allowStaticMethodAccess\']=true,@java.lang.Runtime@getRuntime().exec('calc')}
   ```
2. The `s:url` or `s:a` tag includes this parameter in the generated URL.
3. The OGNL expression is evaluated a second time when the URL is processed, allowing arbitrary code execution.

## Demonstration in This Application
1. **Dynamic Method Invocation**:
   - Enabled in `struts.xml` with the following configuration:
     ```xml
     <constant name="struts.enable.DynamicMethodInvocation" value="true" />
     ```
2. **Vulnerable Tags**:
   - The `dashboard.jsp` and `searchUsers.jsp` files use the `s:url` tag with `includeParams="all"`:
     ```jsp
     <s:url action="userInfo" var="userInfoUrl" includeParams="all" />
     <a href="<s:property value='%{userInfoUrl}' />">Capture User Info</a>
     ```
3. **Exploitation**:
   - A malicious user can inject OGNL expressions into request parameters, which are then included in the generated URL and evaluated.

## Mitigation
To prevent this vulnerability:
1. **Disable Dynamic Method Invocation**:
   - Set `struts.enable.DynamicMethodInvocation` to `false` in `struts.xml`.
2. **Avoid `includeParams="all"`**:
   - Use `includeParams="none"` or `includeParams="get"` to limit the parameters included in the URL.
3. **Validate User Input**:
   - Ensure all user input is properly validated and sanitized.
4. **Upgrade Struts**:
   - Use a patched version of Apache Struts 2 where this vulnerability is fixed.

## Disclaimer
This application is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.