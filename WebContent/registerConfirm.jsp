<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<p>こちらでよろしいですか</p>
	<form action="registerConfirm" method="post">
		<div>
			<label>Name</label><input type="text" name="name" value="${sessionScope.name}">
		</div>
		<div>
			<label>PASS</label><input type="password" name="pass" value="${sessionScope.pass}">
		</div>

		<input type="submit" value="登録">
	</form>
	<div>
		<a href="register.jsp">Back</a>
	</div>
</body>
</html>