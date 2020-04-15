<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Доска объявлений</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Список объявлений</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <a class="btn btn-success" id="but-a" href='${pageContext.request.contextPath}/bulletin/add'>Добавить
            обявление</a>
        <a class="btn btn-primary" id="exit" href='${pageContext.request.contextPath}/'>Выход</a>
        <form class="form-inline" action="${pageContext.request.contextPath}/bulletin/search" method="post">
            <div class="form-group">
                <input type="text" name="searchLine" class="form-control" placeholder="Введите строку" id="search">
            </div>
            <button type="submit" class="btn btn-default">Поиск</button>
        </form>
        <table>
            <tr>
                <th>Наименование</th>
                <th>Цена</th>
                <th>Действие</th>
            </tr>
            <c:forEach var="bulletin" items="${bulletins}">
                <c:url var="details" value="${pageContext.request.contextPath}/bulletin/details">
                    <c:param name="id" value="${bulletin.id}"/>
                </c:url>
                <tr>
                    <td>${bulletin.name}</td>
                    <td>${bulletin.price}</td>
                    <td>
                        <a href="${details}">Детали</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
