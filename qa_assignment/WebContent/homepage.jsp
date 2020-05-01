<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logon success</title>
</head>
<body>
<h1>Welcome ${param.username}</h1> 
<h1>You are in homepage</h1>
<input type="button" value="退出" onclick="javascript:history.go(-1);" />
</body>
</html>