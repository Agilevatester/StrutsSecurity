# S2-037 Vulnerability Demonstration - CVE-2016-4438

### Overview
Apache Struts 2.3.20 to 2.3.28.1, used in this project, is vulnerable to CVE-2016-4438. This vulnerability arises from the improper handling of user inputs in the REST plugin, allowing attackers to inject malicious OGNL expressions. This can lead to remote code execution on the server.

### Proof of Concept (PoC)
1. **REST Plugin Exploit**:
   - By sending a specially crafted HTTP request to the REST endpoint, an attacker can inject OGNL expressions that are evaluated on the server, leading to arbitrary code execution.

### Exploitation Example

To exploit the CVE-2016-4438 vulnerability in this application, you can use the following payload:

```http
POST http://localhost:8080/orders HTTP/1.1
Content-Type: application/json

{
  "id": "1",
  "clientName": "@java.lang.Runtime@getRuntime().exec('calc')",
  "amount": 100
}
```

This payload injects an OGNL expression that attempts to execute the `calc` command on the server. It demonstrates how an attacker could exploit the REST plugin vulnerability to execute arbitrary commands.

### Mitigation
To address this vulnerability:

1. **Upgrade Struts**:
   - Upgrade to Apache Struts version 2.3.29 or later, where this vulnerability is patched.

2. **Input Validation**:
   - Ensure all user inputs are properly validated and sanitized to prevent OGNL injection.

3. **Disable OGNL Evaluation**:
   - Configure Struts to disable OGNL evaluation for untrusted inputs.

### Disclaimer
This application is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.