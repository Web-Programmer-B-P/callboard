<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <title>Редактирование</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href='<spring:url value="/resources/common.css"/>' rel="stylesheet" />
</head>
<body>
<div class="container">
    <div id="header">
        <h2>Форма редактирования объявления</h2>
    </div>
    <form:form action="update" modelAttribute="item" method="post">
        <form:hidden path="id"/>
        <div class="form-group">
            <label for="name">Имя: </label>
            <form:input class="form-control" path="name"/>
            <form:errors path="name" cssClass="user-errors"/>
        </div>
        <div class="form-group">
            <label for="description">Описание: </label>
            <form:textarea class="form-control" path="description" rows="3" cols="32"/>
            <form:errors path="description" cssClass="user-errors"/>
        </div>
        <div class="form-group">
            <label for="name">Цена: </label>
            <form:input class="form-control" pattern="[0-9]+" path="price"/>
            <form:errors path="price" cssClass="user-errors"/>
        </div>
        <div style="display: flex; justify-content: space-between">
            <button type="submit" class="btn btn-success">Сохранить</button>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/item/list">Вернуться к списку</a>
        </div>
    </form:form>
</div>
</body>
</html>