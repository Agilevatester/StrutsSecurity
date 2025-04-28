<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Modify File</title>
</head>
<body>
<h1>Modify File</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <label for="file">Select a new file to replace:</label>
    <input type="file" id="file" name="upload" />
    <input type="hidden" name="fileName" value="<%= request.getParameter("fileName") %>" />
    <input type="submit" value="Upload" />
</form>
</body>
</html>