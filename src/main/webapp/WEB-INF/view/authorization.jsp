<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Авторизация</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 600px">
    <div id="loginbox" style="margin-top: 150px;"
         class="mainbox">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: #09C332; border-color: #09C332; color: #FFFFFF">
                <div class="panel-title" style="text-align: center">Форма авторизации</div>
            </div>
            <div style="padding-top: 30px" class="panel-body">
                <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                           method="POST" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Неправильный логин или пароль!
                                    </div>
                                </c:if>
                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                        Вы успешно разлогинены!
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="username" placeholder="имя" class="form-control"
                               style="height: 54px; font-size: 16px">
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" placeholder="пароль" class="form-control"
                               style="height: 54px; font-size: 16px">
                    </div>
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">Авторизоваться</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>