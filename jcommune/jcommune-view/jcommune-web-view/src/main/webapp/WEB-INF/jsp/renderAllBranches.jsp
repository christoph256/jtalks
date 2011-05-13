<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Christoph
  Date: 12.05.2011
  Time: 22:54:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<form:form method="POST">
    <table border="1" width="100%">

        <c:forEach var="branches" items="${topicsBranchList}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/branches/${branches.id}.html"> <c:out
                        value="${branches.name}"/></a></td>
                <td><c:out value="${branches.description}"/></td>                
            </tr>
        </c:forEach>
    <table>
</form:form>
</body>
</html>