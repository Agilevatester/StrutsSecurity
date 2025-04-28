<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Multiple File Upload</title>
</head>
<body>
<h2>Multiple File Upload</h2>
<s:form action="multipleFileUpload" method="post" enctype="multipart/form-data">
    <label for="uploads">Choose files:</label>
    <s:file name="uploads" id="uploads" multiple="true"/>
    <s:submit value="Upload"/>
</s:form>
<s:property value="#request.message"/>
</body>
</html>