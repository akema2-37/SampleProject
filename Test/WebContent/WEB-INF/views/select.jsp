<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri = "http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri = "http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索</title>
</head>
<body>

<form action ="/Test/select.do" method ="post">
		　I  D:<input type ="text"name="id"><br>
		名前:<input type ="text" name="name"><br>
		住所:<input type ="text" name ="plice"><br>
		携帯:<input type ="text" name ="phone"><br>
		経歴:<input type ="text" name ="biography"><br>
		<p>
		<input type ="submit" value="検索">
	</form>
	<hr>
	<logic:notEmpty name ="error">
		<bean:write name="error"/><p>
	</logic:notEmpty>

<logic:notEmpty name ="insertFailure">
	<h1><bean:write name="insertFailure"/></h1>
	<hr>
<logic:iterate  id = "thread" name ="select">
		id:  <bean:write name="thread" property ="id"/><br>
		名前:<bean:write name="thread" property ="name"/><br>
		住所:<bean:write name="thread" property ="plice"/><br>
		携帯:<bean:write name="thread" property ="phone"/><br>
		経歴:<bean:write name="thread" property="biography"/><br>
	<hr>
	</logic:iterate>
</logic:notEmpty>
</body>
</html>