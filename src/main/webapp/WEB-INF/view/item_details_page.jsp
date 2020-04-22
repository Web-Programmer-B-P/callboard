<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <title>Детальная страница объявления</title>
    <link href='<spring:url value="/resources/common.css"/>' rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<div class="container" style="margin-top: 200px; text-align: center">
    <div class="row content">
        <div class="col-sm-9">
            <h2><c:out value="${item.name}"/></h2>
            <h5><span>Цена: </span><c:out value="${item.price}"/></h5>
            <p><c:out value="${item.description}"/></p>
            <br>
            <c:url var="delete" value="${rootPath}/item/delete">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:url var="update" value="${rootPath}/item/update">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:if test="${permissionDeleteItem == true}">
                <a class="btn btn-danger btn-sm" href="${delete}"
                   onclick="if (!(confirm('Вы действительно хотите удалить?'))) return false">Удалить</a>
                <a class="btn btn-primary btn-sm" href="${update}">Редактировать</a>
            </c:if>
            <a class="btn btn-success btn-sm" href="${rootPath}/item/list">Вернуться к
                списку</a>
        </div>
    </div>
</div>
</body>
</html>
