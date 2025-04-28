<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<h1>Upload a File</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="upload" />
    <input type="submit" value="Upload" />
</form>
</body>
</html>