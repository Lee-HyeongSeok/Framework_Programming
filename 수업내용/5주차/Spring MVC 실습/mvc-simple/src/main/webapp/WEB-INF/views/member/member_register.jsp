<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
	</head>
<body>
	<div align=center>
		<header>학생 정보 등록</header>
		<form name=form1 action="http://localhost:2020/web/member/register/" method="post">
		<table>
			<tr><th>LoginID</th><td><input type="text" name="id" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>LoginPWD</th><td><input type="text" name="passwd" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>YourName</th><td><input type="text" name="username" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>StudentNumber</th><td><input type="text" name="snum" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>Department</th><td><input type="text" name="depart" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>MobileNUmber</th><td><input type="text" name="mobile" autofocus placeholder="공백없이 입력"></td></tr>
			<tr><th>EmailNumber</th><td><input type="text" name="email" autofocus placeholder="공백없이 입력"></td></tr>
		</table>
		<dl>
			<dd><input type="submit" name="submit" value="보내기"></dd>
			<dd><input type="reset" name="reset" value="재작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>