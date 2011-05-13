<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<form:form action="${pageContext.request.contextPath}/createNewTopic.html" modelAttribute="topicDto" method="POST">
    <table border="2" width="100%">
        <tr>
            <td width="30%">
                <form:label path="topicName"><spring:message code="label.topic"/></form:label>
                <form:input path="topicName"/>
                <form:errors path="topicName"/>
            </td>
        </tr>
        <tr>
            <td width="30%">
                <form:label path="author"><spring:message code="label.author"/></form:label>
                <form:input path="author"/>
                <form:errors path="author"/>
            </td>
        </tr>
        <tr>
            <td height="200">
                <form:label path="bodyText"><spring:message code="label.text"/></form:label>
                <form:textarea path="bodyText"/>
                <form:errors path="bodyText"/>
            </td>
        </tr>
    </table>
    <br><input type="submit" value="<spring:message code="label.addtopic"/>"/>
</form:form>
</body>
</html>