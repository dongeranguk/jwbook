<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="calc" class="ch07.Calculator" />
<jsp:setProperty name="calc" property="*" />

<h2>계산 결과 - JSP</h2>
<hr>
	결과 : <%= calc.calc() %>
</body>
</html>