<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Авторизация</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bulletin.css"/>
</head>
<body>
<div id="container">
    <h3>Добавить пользователя</h3>
    <form:form action="authorization" modelAttribute="user" method="POST">
        <table>
            <tbody>
            <tr>
                <c:if test="${credential != ''}">
                    <p class="credential">${credential}</p>
                </c:if>
                <td><label>Email: </label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="user-errors"/></td>
            </tr>
            <tr>
                <td><label>Password: </label></td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password" cssClass="user-errors"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Авторизоваться" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
