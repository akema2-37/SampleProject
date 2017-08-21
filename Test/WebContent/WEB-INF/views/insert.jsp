<%@ taglib uri = "http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri = "http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri = "http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<logic:notEmpty name="errorMessage">
		<bean:write name="errorMessage" />
		<p>
	</logic:notEmpty>
	<form action="/Test/insert.do" method="post">
		I D:<input type="text" name="id"><br>
		名前:<input type="text" name="name"><br>
		住所:<input type="text" name="plice"><br>
		携帯:<input type="text" name="phone"><br>
		経歴:<input type="text" name="biography"><br>
		<input type="submit" value="新規社員"><br>
		<input type="hidden" name="send" value="">
	</form>

</body>
</html>