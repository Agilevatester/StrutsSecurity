<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Uploaded Files</h1>
<ul>
    <%-- List uploaded files dynamically --%>
    <c:forEach var="file" items="${uploadedFiles}">
        <li><a href="modifyFile.jsp?fileName=${file}">${file}</a></li>
    </c:forEach>
</ul>
</body>
</html>