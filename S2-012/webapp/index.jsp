<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>S2-012 PoC</title>
</head>
<body>
<h1>S2-012 Vulnerability PoC</h1>
<form action="redirect/vulnerableRedirect.action" method="post">
    <label for="redirectParam">Enter Redirect Parameter:</label>
    <input type="text" id="redirectParam" name="redirectParam" />
    <button type="submit">Submit</button>
</form>
</body>
</html>