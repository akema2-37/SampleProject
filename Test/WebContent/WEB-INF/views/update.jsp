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
<title>更新</title>
</head>
<body>

		<logic:notEmpty name ="error">
			<bean:write name ="error"/><p>
		</logic:notEmpty>
		<hr>
		<logic:iterate id ="thread" name ="db">
			<form action ="/Test/update.do" method="post">
				名前:<input type="text" name="name" value ="${thread.name}"><br>
				住所:<input type="text" name="plice" value ="${thread.plice}"><br>
				携帯:<input type="text" name="phone" value ="${thread.phone}"><br>
				経歴:<input type="text" name="biography" value="${thread.biography}"><br>
					<input type ="hidden" name ="id" value="${thread.id}">
				<input type="submit" value="データ更新"><br>
				<input type="hidden" name="send" value="">
			</form>
		</logic:iterate>

</body>
</html>