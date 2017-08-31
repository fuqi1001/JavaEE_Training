<%--
  Created by IntelliJ IDEA.
  User: qifu
  Date: 17/8/29
  Time: PM1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
<head><title>Hello ${userName}</title></head>
<body style="text-align: center;">
<c:choose>
    <c:when test="${not empty invalidUser and !invalidUser}">
        <h2>Welcome ${userName} </h2>
        <a href="/" >Log out</a>
        <table align="center">
            <tr><td>
                <a href="/addDepartment.jsp">Add Department</a>
            </td></tr>
            <tr><td>
                <a href="/addEmployee.jsp">Add Employee</a>
            </td></tr>
        </table>
    </c:when>
    <c:otherwise>
        Please Log in first.<a href="/" >Log in</a>
    </c:otherwise>
</c:choose>
</body>
</html>
