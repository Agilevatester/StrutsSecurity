<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome, <s:property value="#session.username" />!</h2>
    <s:url action="userInfo" var="userInfoUrl" includeParams="all" />
    <a href="<s:property value='%{userInfoUrl}' />">Capture User Info</a>
</body>
</html>