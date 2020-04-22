<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Доска объявлений</title>
    <link href='<spring:url value="/resources/common.css"/>' rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="font-size: 0">
<security:authentication var="user" property='principal.username'/>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div id="header">
        <h2>Список объявлений</h2>
    </div>
    <div style="display: flex; margin: 10px 0; justify-content: space-between">
        <a class="btn btn-success" style="background-color: #09c332;" id="but-a" href='${rootPath}/item/add'>Добавить обявление</a>
        <form:form action="${rootPath}/logout"
                   method="POST" class="form-horizontal">
            <button type="submit" class="btn btn-primary">Выход</button>
        </form:form>
    </div>
    <form:form class="form-inline" action="${rootPath}/item/search" method="post">
        <div class="form-group">
            <input type="text" name="searchLine" class="form-control" placeholder="Введите строку" id="search">
        </div>
        <button type="submit" class="btn btn-default" style="margin-left: 10px; background-color: #e6e6e6">Поиск</button>
    </form:form>
    <table class="table table-striped" style="margin-top: 40px">
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Цена</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <c:url var="details" value="${rootPath}/item/details">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>
                    <a href="${details}">Детали</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
