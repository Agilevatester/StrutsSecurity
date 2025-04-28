# Struts S2-008 Proof of Concept (POC)

## Overview
This Proof of Concept (POC) demonstrates the Apache Struts2 vulnerability identified as S2-008. The vulnerability allows attackers to execute arbitrary OGNL (Object-Graph Navigation Language) expressions, leading to potential remote code execution (RCE).

## Vulnerability Details
The S2-008 vulnerability arises due to improper handling of user input in Struts2 applications. Specifically, when user input is directly evaluated as an OGNL expression, attackers can inject malicious payloads to execute arbitrary code on the server.

## POC Structure
- **`src/com/demo/action/VulnerableAction.java`**: Contains the vulnerable action class that echoes user input.
- **`webapp/WEB-INF/struts.xml`**: Configures the Struts2 action mapping.
- **`webapp/welcome.jsp`**: Displays the result of the vulnerable action.
- **`webapp/WEB-INF/web.xml`**: Configures the Struts2 filter.

## Exploitation Steps
1. Deploy the application on a servlet container (e.g., Apache Tomcat).
2. Access the vulnerable endpoint, e.g., `http://<server>:<port>/S2-008/vulnerable.action`.
3. Inject a malicious OGNL payload in the `input` parameter. For example:
   ```
   input=%{#context["com.opensymphony.xwork2.dispatcher.HttpServletResponse"].addHeader("X-Exploit", "S2-008")}
   ```
4. Observe the response headers to confirm the payload execution.

## Mitigation
To mitigate this vulnerability, upgrade to a patched version of Struts2 and avoid directly evaluating user input as OGNL expressions.