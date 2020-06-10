<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action="<%=getServletContext().getContextPath()%>/test.do"/>
		姓名<input name="name" type="text"/><br/>
		年龄<input name="age" type="text"/><br/>
		分数<input name="score" type="text"/><br/>		
		班级序号<input name="classid" type="text"/>	<br/>
		<input type="submit" value="提交"/>	<br/>
	</form>
	
	${Message }
</body>
</html>