<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Search Users</title>
</head>
<body>
    <h2>Search Users</h2>
    <s:url action="searchUsers" var="searchUrl" includeParams="all" />
    <script>
        const searchUrl = '<s:property value="%{searchUrl}" />';
        // Use searchUrl in AJAX calls
    </script>
    <s:form action="searchUsers" method="post">
        <s:textfield name="searchQuery" label="Search" />
        <s:submit value="Search" />
    </s:form>

    <h3>Search Results</h3>
    <s:if test="users != null && !users.isEmpty()">
        <ul>
            <s:iterator value="users" var="user">
                <li><s:property value="#user.name" /> - <s:property value="#user.email" /></li>
            </s:iterator>
        </ul>
    </s:if>
    <s:else>
        <p>No users found.</p>
    </s:else>
</body>
</html>