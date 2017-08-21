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
<title>トップ画面</title>
</head>
<body>
	<h1>トップ画面</h1>
	<hr>
	<a href="/Test/insert.do">書き込み</a>
	<hr>

	<form action="/Test/select.do" method="post">
		I D:<input type="text" name="id"><br>
		名前:<input type="text" name="name"><br>
		住所:<input type="text"name="plice"><br>
		携帯:<input type="text" name="phone"><br>
		経歴:<input type="text" name="biography"><br>
		<input type="submit" value="検索">
	</form>

	<hr>
	<logic:iterate id="thread" name="db">
		id:  <bean:write name="thread" property="id" />
		<br>
		名前:<bean:write name="thread" property="name" />
		<br>
		住所:<bean:write name="thread" property="plice" />
		<br>
		携帯:<bean:write name="thread" property="phone" />
		<br>
		経歴:<bean:write name="thread" property="biography"/>
		<p>
			<html:form action="/update" method="post">
				<html:hidden property="id" value="${thread.id}" />
				<html:submit value="更新" />
			</html:form>
			<html:form action ="/delete" method="post">
				<html:hidden property="id" value="${thread.id }"/>
				<html:submit value="削除"/>
			</html:form>
		<hr>

	</logic:iterate>

	<logic:iterate id="navi" name="navis">

		<html:link action="/view.do?p=${navi}">${navi}</html:link>


	</logic:iterate>


</body>
</html>