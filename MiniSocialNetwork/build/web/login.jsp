<%-- 
    Document   : index
    Created on : Sep 14, 2020, 2:44:31 PM
    Author     : phamduchieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/cascadingStyleSheet.css" rel="stylesheet" type="text/css">
        <script src="./js/javascript.js" type="text/javascript"></script>
        <title>Social Network - Login</title>
    </head>
    <body>
        <img class="bg-login" src="images/background-login.png"/>
        <div id="login-form"> 
            <label id="lbCurrentTime">${applicationScope.CURRENT_TIME}</label>
            <label id="lbLogin">Login</label>
            <form action="MainController" method="POST">
                <label id="lbEmail">Email</label>
                <input id="txtEmail" onblur="hideLbEmail()" onfocus="showLbEmail()" class="text-input" type="text" name="txtEmail" value="" placeholder="Email"/><br/>
                <label id="lbPassword">Password</label>
                <input id="txtPassword" onblur="hideLbPassword()" onfocus="showLbPassword()" class="text-input" type="password" name="txtPassword" value="" placeholder="Password"/><br/>
                <input class="default-button button-spacing-login" type="submit" value="Sign in" name="action" />
            </form>
            <c:url var="signUp" value="MainController">
                <c:param name="action" value="signUp"/>
            </c:url>
            <a class="default-link link-spacing-login" href="${signUp}">Sign up new account</a>
        </div>
        <img class="default-logo" src="images/ms_logo_shadow.png"/>
    </nav>
</body>
</html>
