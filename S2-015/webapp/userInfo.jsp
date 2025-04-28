<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <h2>Capture User Information</h2>
    <s:form action="userInfo" method="post">
        <s:textfield name="name" label="Name" />
        <s:textfield name="email" label="Email" />
        <s:submit value="Save" />
    </s:form>
</body>
</html>