<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <s:form action="login" method="post">
        <s:textfield name="username" label="Username" />
        <s:password name="password" label="Password" />
        <s:submit value="Login" />
    </s:form>
    <s:actionerror />
</body>
</html>