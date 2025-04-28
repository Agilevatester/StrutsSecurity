<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Single File Upload</title>
</head>
<body>
<h2>Single File Upload</h2>
<s:form action="singleFileUpload" method="post" enctype="multipart/form-data">
    <label for="upload">Choose a file:</label>
    <s:file name="upload" id="upload"/>
    <s:submit value="Upload"/>
</s:form>
<s:property value="#request.message"/>
</body>
</html>