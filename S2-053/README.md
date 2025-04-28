# S2-053: CVE-2017-12611 Vulnerability Demonstration

## Overview
CVE-2017-12611 is a vulnerability in Apache Struts 2 that allows for a potential Remote Code Execution (RCE) attack. This occurs when unintentional expressions are used in Freemarker tags instead of string literals. Freemarker treats writable properties in the `value` attribute as expressions, which can be exploited if request values are used.

## Affected Versions
- Apache Struts 2.0.0 to 2.3.33
- Apache Struts 2.5 to 2.5.10.1

## Vulnerable Implementation
The following is an example of a vulnerable Freemarker tag:

```jsp
<@s.hidden name="name" value="${name}" />
```

In this example, the `value` attribute is treated as an expression by Freemarker, which can lead to an RCE attack if the `name` value is controlled by an attacker.

## Exploitation Example

The following example demonstrates how the CVE-2017-12611 vulnerability can be exploited:

1. **Setup**: A vulnerable Freemarker tag is used in the application:

   ```jsp
   <@s.hidden name="name" value="${name}" />
   ```

2. **Attack**: An attacker sends a crafted request to the server, injecting malicious code into the `name` parameter. For example:

   ```http
   GET /vulnerableApp?name=${"freemarker.template.utility.Execute"?new()("calc")}
   ```

   In this case, the attacker uses Freemarker's `Execute` utility to execute the `calc` command, which opens the calculator application on the server.

3. **Result**: The server processes the request and evaluates the `value` attribute as an expression. This leads to the execution of the injected code, resulting in Remote Code Execution (RCE).

## Important Notes
- This example is for educational purposes only. Do not use this information for malicious activities.
- Always sanitize user inputs and avoid using dynamic expressions in Freemarker tags.

## Mitigation
To mitigate this vulnerability:
1. Avoid using such constructions in your code.
2. Use read-only properties (properties with only a getter) to initialize the `value` attribute.
3. Upgrade to a secure version of Apache Struts:
   - Struts 2.5.12
   - Struts 2.3.34

## Mitigation Steps
- Inspect your codebase for similar patterns and replace them with safe alternatives.
- Upgrade to a secure version of Apache Struts as mentioned above.

## References
- [Apache Struts Security Bulletin S2-053](https://cwiki.apache.org/confluence/display/WW/S2-053)