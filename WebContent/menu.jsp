<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<p>
		<a href="taskRegister.jsp">Task登録</a>
		<a href="battle.jsp">Battle</a>
		<a href="logout.jsp">Logout</a>
	</p>
	<p>Task</p>
	<p>Unfinished</p>
	<p>
	<fieldset>
	<form action="taskFinish" method="post">
		<div>
		<input type="checkbox" id = "task1" name="task1" value="1">
		<label for="tasl1">ディスカッションアンケートに答える</label>
		</div>
		<input type="submit" value="Finish">
	</form>
	</fieldset>
	</p>
	<p>Unfinished</p>
	<p>
	<fieldset>
	<form action="taskDelete" method="post">
		<div>
		<input type="checkbox" id = "task1" name="task1" value="1">
		<label for="tasl1">ディスカッションアンケートに答える</label>
		</div>
		<input type="submit" value="Delete">
	</form>
	</fieldset>
	</p>
	<div>
		<a href="index.jsp">TOP画面に戻る</a>
	</div>
	<p>Character</p>
	<img src="image/Penguins.jpg" width="205" height="180">
	<p>LV 3</p>
	<p>Exp 20/40</p>
	<p>HP 40/40<p>
</body>
</html>