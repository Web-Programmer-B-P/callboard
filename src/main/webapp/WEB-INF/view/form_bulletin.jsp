<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Новое объявление</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bulletin.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Форма добавления объявления</h2>
    </div>
</div>
<div id="container">
    <form:form action="save" modelAttribute="bulletin" method="post">
        <form:hidden path="id"/>
        <table class="form">
            <tbody>
            <tr>
                <td><label>Название: </label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="user-errors"/></td>
            </tr>
            <tr>
                <td><label>Описание: </label></td>
                <td><form:textarea path="description" rows="3" cols="32"/></td>
                <td><form:errors path="description" cssClass="user-errors"/></td>
            </tr>
            <tr>
                <td><label>Цена: </label></td>
                <td><form:input path="price"/></td>
                <td><form:errors path="price" cssClass="user-errors"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Сохранить" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both"></div>
    <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/bulletin/list">Вернуться к списку</a>
</div>
</body>
</html>
