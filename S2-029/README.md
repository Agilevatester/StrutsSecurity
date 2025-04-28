# S2-029 Vulnerability Demonstration - CVE-2016-0785

### Overview
Apache Struts 2.3.24.1, used in this project, is vulnerable to CVE-2016-0785. This vulnerability arises from the double evaluation of attributes' values assigned to certain tags. An attacker can exploit this behavior to inject malicious OGNL expressions, leading to potential remote code execution or other security risks.

### Proof of Concept (PoC)
1. **Double Evaluation Exploit**:
   - By crafting a specially designed request, an attacker can pass a value that will be evaluated twice when a tag's attributes are rendered. This can lead to the execution of unintended OGNL expressions.

### Exploitation Example

To exploit the CVE-2016-0785 vulnerability in this application, you can use the following payload:

```http
http://localhost:8080/example/index.action?attribute=%25{#context['com.opensymphony.xwork2.dispatcher.HttpServletResponse'].addHeader('Exploit','Success')}
```

This payload injects an OGNL expression that adds a custom header (`Exploit: Success`) to the HTTP response. It demonstrates how an attacker could exploit the double evaluation vulnerability to execute arbitrary OGNL expressions.

### Mitigation
To address this vulnerability:

1. **Upgrade Struts**:
   - Upgrade to a version of Apache Struts where CVE-2016-0785 is patched (e.g., 2.3.29 or later).

2. **Input Validation**:
   - Ensure all user inputs are properly validated and sanitized to prevent OGNL injection.

3. **Disable OGNL Evaluation**:
   - Configure Struts to disable OGNL evaluation for untrusted inputs.

### Disclaimer
This application is for educational purposes only. Exploiting vulnerabilities without proper authorization is illegal and unethical.