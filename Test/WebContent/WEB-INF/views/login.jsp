<%@ taglib uri = "http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri = "http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri = "http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>

	<logic:notEmpty name ="errorMessage">
		<bean:write name="errorMessage"/><p>
	</logic:notEmpty>

	<form action ="/Test/login.do" method="post">
		ログイン :<input type="text" name="name"/><p>
		暗証番号:<input type="password" name="password"/><p>
		<input type ="submit" value ="送信"/>
		<input type="hidden" name="btnLoginClicked" value="" />
	</form>

</body>
</html>