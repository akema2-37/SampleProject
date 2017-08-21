<%@ page import="java.util.List"%>
<%@ page import="publish.ThreaBean"%>
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
	<h2>以下の内容を削除しますか？</h2>
	<hr>
	<logic:iterate id ="thread" name="db">
		<form action ="/Test/delete.do" method="post">
		名前:<bean:write  name="thread" property ="name"/><br>
		住所:<bean:write  name="thread" property="plice"/><br>
		携帯:<bean:write  name="thread" property="phone"/><br>
		経歴:<bean:write  name="thread" property="biography"/><br>
			 <input type ="hidden" name="id"  value="${thread.id}">
			 <hr>
			 <input type ="submit" value ="削除"><br>
			 <input type ="hidden" name ="delete" value="">
		</form>
	</logic:iterate>
</body>
</html>