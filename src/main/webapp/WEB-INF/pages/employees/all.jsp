<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>Employyers of department "${departments.name}"</b></td>
    </tr>
<c:forEach var="employeer" items="${departments.empls}">
    <tr>
        <td>${employeer.firstName}</td>
        <td> <a href="/emplEdit?emId=${employeer.id}&depId=${departments.id}">Edit</a> | <a href="/deleteEmpl?emId=${employeer.id}&depId=${departments.id}">Delete</a> </td>
    </tr>
</c:forEach>
<tr>
    <td colspan="5">
        <a href="/emplAddPage?depId=${departments.id >= 0 ? departments.id : 0}">Add new one</a>
    </td>
</tr>
    <tr>
        <td><a href="/dep">Departments</a></td>
    </tr>
</table>
</body>
</html>
