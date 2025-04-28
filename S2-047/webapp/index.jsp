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

<h1>URL Validation</h1>
<form action="validateURL" method="post">
    <label for="url">Enter URL:</label>
    <input type="text" id="url" name="url" />
    <input type="submit" value="Validate" />
</form>
<p>Note: Entering a specially crafted URL in the form above can lead to a Denial of Service (DoS) condition by overloading the server during validation. This demonstrates the vulnerability CVE-2017-7672.</p>
</body>
</html>