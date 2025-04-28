# S2-007 Vulnerable Application

## About the Vulnerability
Apache Struts2 versions prior to 2.3.1.2 are vulnerable to a Remote Code Execution (RCE) attack due to improper handling of user input in OGNL expressions. This vulnerability, identified as S2-007, allows attackers to execute arbitrary commands on the server by injecting malicious OGNL expressions into HTTP requests.

### Root Cause
The vulnerability arises from the way Struts2 processes user input in OGNL expressions. Specifically, user-supplied data is not properly sanitized, allowing attackers to craft malicious payloads that are executed on the server.

### Affected Versions
- Apache Struts2 versions prior to 2.3.1.2

## Exploitation
To exploit this vulnerability, an attacker can send a specially crafted HTTP request to the vulnerable application. The payload in the request will include malicious OGNL expressions that are evaluated on the server, leading to arbitrary code execution.

### Example Exploit
1. Access the vulnerable endpoint (e.g., `/vulnerable`).
2. Inject a malicious payload into the `command` parameter, such as:
   ```
   command=calc.exe
   ```
3. Submit the request. The server will execute the command, in this case, opening the calculator application.

### UserAction.java Vulnerability

The `UserAction.java` class in this project is vulnerable to OGNL expression evaluation when there is a conversion error. This vulnerability occurs because user input is directly mapped to class properties without proper validation or sanitization. If a malicious payload is sent to the application, it can trigger OGNL expression evaluation, leading to potential Remote Code Execution (RCE).

#### Example Payload
An attacker can exploit this vulnerability by sending a specially crafted HTTP request with a payload like:

```
age=(#context[\'xwork.MethodAccessor.denyMethodExecution\']=false,#_memberAccess[\'allowStaticMethodAccess\']=true,@java.lang.Runtime@getRuntime().exec('calc.exe'))
```

#### Exploitation Steps
1. Send the above payload to the endpoint handling `UserAction` (e.g., `/user`).
2. The server processes the input and evaluates the OGNL expression due to a conversion error.
3. The malicious command (`calc.exe` in this case) is executed on the server.

#### Mitigation
To prevent this vulnerability:
- Validate and sanitize all user inputs.
- Use a strict type conversion mechanism to avoid OGNL expression evaluation.
- Upgrade to a secure version of Apache Struts2 that addresses this issue.

## Mitigation
To mitigate this vulnerability:
- Upgrade to Apache Struts2 version 2.3.1.2 or later.
- Use input validation and sanitization to prevent malicious payloads.
- Apply security patches and follow best practices for securing web applications.

## Disclaimer
This application is intentionally vulnerable and should only be used for educational purposes in a controlled environment. Do not deploy this application in a production environment.