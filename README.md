# StrutsSecurity

This repository contains Proof of Concept (PoC) projects for various Apache Struts vulnerabilities. Each subfolder represents a specific vulnerability demonstration.

## Child Projects

### S2-001
- **Description**: Demonstrates the vulnerability in `<s:textfield>` tag.
- **Affected Versions**: 2.0.0-2.0.8

### S2-003
- **Description**: Exploits `ParametersInterceptor` to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.1.8.1

### S2-007
- **Description**: Exploits `ConversionErrorInterceptor` to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.2.3

### S2-008
- **Description**: Exploits `CookieInterceptor` to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.3.1.1

### S2-009
- **Description**: Exploits `ParametersInterceptor` with ASCII ordering to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.3.1.1

### S2-012
- **Description**: Exploits redirect result type to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.3.14.2

### S2-013
- **Description**: Exploits `<s:a>` and `<s:url>` tags with `includeParams` attribute.
- **Affected Versions**: 2.0.0-2.3.14.1

### S2-015
- **Description**: Exploits wildcard action mapping to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.0.8

### S2-016
- **Description**: Exploits `DefaultActionMapper` with `redirect:` prefix.
- **Affected Versions**: 2.0.0-2.3.15

### S2-019
- **Description**: Exploits `DebuggingInterceptor` to execute OGNL expressions.
- **Affected Versions**: 2.0.0-2.3.15.1

### S2-029
- **Description**: Exploits `<s:textfield>` tag with `%{}` in `name` attribute.
- **Affected Versions**: 2.0.0-2.3.24.1 (except 2.3.20.3)

### S2-037
- **Description**: Exploits `method:` prefix in `DefaultActionMapper`.
- **Affected Versions**: 2.3.20-2.3.28 (except 2.3.20.3, 2.3.24.3)

### S2-045
- **Description**: Exploits Jakarta Multipart parser for RCE.
- **Affected Versions**: 2.3.5-2.3.31 or 2.5-2.5.10

### S2-046
- **Description**: Exploits file upload filename validation for RCE.
- **Affected Versions**: 2.3.5-2.3.31 or 2.5-2.5.10

### S2-052
- **Description**: Exploits `ContextTypeInterceptor` for XML/JSON deserialization.
- **Affected Versions**: 2.1.6-2.3.33 or 2.5-2.5.12

### S2-055
- **Description**: Exploits `ContextTypeInterceptor` for XML/JSON deserialization.
- **Affected Versions**: 2.1.6-2.3.33 or 2.5-2.5.12

### S2-066
- **Description**: Demonstrates CVE-2023-50164 with single and multiple file upload functionality.
- **Affected Versions**: Refer to [S2-066 Documentation](https://cwiki.apache.org/confluence/display/WW/S2-066)

## Usage
Each subfolder contains a standalone project demonstrating the specific vulnerability. Follow the instructions in the respective `README.md` files to set up and run the PoC.