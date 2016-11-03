<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form method="post" action="/emplAdd">
    <table>
        <tr>
            <td><label>Department id:</label></td>
            <!--<td><input type="text" name="id2" value="${departments.id}"></td> -->
        </tr>

        <tr>
            <td>
                <select name="id">
                    <option selected value="${departments.id}">${departments.name}</option>
                    <c:forEach  var="dep" items="${depList}">
                        <option value="${dep.id}">${dep.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td><label>Employeer name:</label></td>
            <td><input type="text" name="name" value="${empl.firstName}"></td>
            <td><input type="hidden" name="emId" value="${empl.id}"></td>
        </tr>

        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
