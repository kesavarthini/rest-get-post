<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action = "register" modelAttribute="employee" method ="post"><br><br>
ID:<form:input path="id"/>
<form:errors path="id" /><br><br>
NAME:<form:input path="name"/>
<form:errors path="name" /><br><br>
AGE:<form:input path="age"/><br><br>
<form:errors path="age" />
SALARY:<form:input path="salary"/>
<form:errors path="salary" /><br><br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>