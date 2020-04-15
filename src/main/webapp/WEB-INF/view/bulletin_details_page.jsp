<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Детальная страница объявления</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-9">
            <h2>${bulletin.name}</h2>
            <h5><span>Цена: </span>${bulletin.price}</h5>
            <p>${bulletin.description}</p>
            <br>
            <c:url var="delete" value="${pageContext.request.contextPath}/bulletin/delete">
                <c:param name="id" value="${bulletin.id}"/>
            </c:url>
            <c:url var="update" value="${pageContext.request.contextPath}/bulletin/update">
                <c:param name="id" value="${bulletin.id}"/>
            </c:url>
            <c:if test="${permissionDeleteBulletin == true}">
                <a class="btn btn-danger btn-sm" href="${delete}"
                   onclick="if (!(confirm('Вы действительно хотите удалить?'))) return false">Удалить</a>
                <a class="btn btn-primary btn-sm" href="${update}">Редактировать</a>
            </c:if>
            <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/bulletin/list">Вернуться к
                списку</a>
        </div>
    </div>
</div>
</body>
</html>
