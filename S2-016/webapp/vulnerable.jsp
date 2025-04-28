<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Vulnerable Page</title>
</head>
<body>
    <h2>Vulnerable Page</h2>
    <s:form action="vulnerableAction">
        <s:textfield name="input" label="Input" />
        <s:submit value="Submit" />
    </s:form>
    <p>Submitted Input: <s:property value="input" /></p>
</body>
</html>