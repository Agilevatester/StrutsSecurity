<html>
<head>
<title>S2-053 Demo</title>
</head>
<body>
<h1>S2-053 Demo</h1>
<hr/>
<!-- Vulnerable usage: The following Freemarker tag uses the 'value' attribute with a dynamic expression '${name}'.
     This can lead to Remote Code Execution (RCE) if the 'name' parameter is controlled by an attacker.
     Freemarker treats the 'value' attribute as an expression, which is evaluated at runtime. -->
Your name: <@s.url value="${name}"/>
<hr/>
Enter your name here:<br/>
<form action="" method="get">
<input type="text" name="name" value="" />
<input type="submit" value="Submit" />
</form>
<br/><br/><br/>
<p>See more info at: <a href="https://cwiki.apache.org/confluence/display/WW/S2-053">Security Bulletins - S2-053</a></p>
</body>
</html>