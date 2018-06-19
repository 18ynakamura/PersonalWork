<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="register" method="post">
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(param.id)}">
    </div>
    <div>
      <label>PASS</label><input type="password" name="pass" value="${fn:escapeXml(param.pass)}">
    </div>
     <div>
      <label>Name</label><input type="text" name="name" value="${fn:escapeXml(param.name)}">
    </div>
  <input type="submit" value="登録">
</form>
<div>
  <a href="index.jsp">Back</a>
</div>
</body>
</html>