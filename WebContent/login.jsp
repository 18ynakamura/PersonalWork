<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<c:if test="${not empty msg}">
<p>${msg} </p>
</c:if>
<form action="login" method="post">
    <div>
      <label>NAME</label><input type="text" name="name" value="${fn:escapeXml(param.name)}">
    </div>
    <div>
      <label>PASS</label><input type="password" name="pass" value="${fn:escapeXml(param.pass)}">
    </div>
  <input type="submit" value="ログイン">
</form>
<div>
  <a href="index.jsp">TOP画面に戻る</a>
</div>
</body>
</html>