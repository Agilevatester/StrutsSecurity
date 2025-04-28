# S2-057: CVE-2018-11776 Vulnerability Demonstration

## Overview
CVE-2018-11776 is a critical Remote Code Execution (RCE) vulnerability in Apache Struts 2. It occurs when `alwaysSelectFullNamespace` is set to `true` (either by the user or a plugin like the Convention Plugin), and results or `url` tags are used without proper `namespace`, `value`, or `action` attributes. This can lead to exploitation if the upper package has no or wildcard namespace.

## Exploitation Example

The following steps demonstrate how this vulnerability can be exploited:

1. **Setup**: The application is configured with `alwaysSelectFullNamespace` set to `true` in `struts.xml`.

2. **Crafted Request**: An attacker sends a malicious request to the server, exploiting the lack of proper namespace or action attributes in the configuration. For example:

   ```http
   GET /S2-057/order.action?redirect:${%23a%3d(new%20java.lang.ProcessBuilder(%22calc%22)).start()} HTTP/1.1
   Host: vulnerable-app.com
   ```

   This payload uses OGNL (Object-Graph Navigation Language) to execute arbitrary commands on the server.

3. **Result**: The server processes the request and evaluates the OGNL expression, leading to Remote Code Execution (RCE).

## Mitigation
To mitigate this vulnerability:
1. Upgrade to Apache Struts version 2.3.35 or 2.5.17.
2. Ensure that all `namespace`, `value`, and `action` attributes are properly defined in your configuration.
3. Avoid using wildcard namespaces in your application.

## Project Structure
- `web.xml`: Configures the Struts2 filter.
- `pom.xml`: Defines the Maven project structure and dependencies.
- `struts.xml`: Configures the Struts2 actions and sets `alwaysSelectFullNamespace` to `true`.
- `order.jsp` and `confirm.jsp`: Demonstrate the order and confirmation flows.

## Important Notes
- This example is for educational purposes only. Do not use this information for malicious activities.
- Always validate and sanitize user inputs to prevent exploitation.

## References
- [Apache Struts Security Bulletin S2-057](https://cwiki.apache.org/confluence/display/WW/S2-057)