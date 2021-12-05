<%-- 
    Document   : header
    Created on : Sep 19, 2020, 4:40:55 PM
    Author     : phamduchieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/cascadingStyleSheet.css" rel="stylesheet" type="text/css">
        <script src="./js/javascript.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="nav-header bg-light-gray80">
            <c:if test="${sessionScope.USER_INFO != null}">
                <c:if test="${not empty sessionScope.USER_INFO}">
                    <li class="part-contain-header"></li>
                    <li class="part-contain-header">
                        <form action="MainController" method="POST">
                            <button type="submit" class="home-btn">                            
                                <img id="logo-header" src="images/logo_header.png"/>
                            </button>
                        </form>
                    </li>
                    <li class="part-contain-header"></li>
                    <li class="part-contain-header">
                        <input type="text" id="search-field" placeholder="Search by post title"/>
                        <button id="search-button" type="submit" value="search">
                            <img id="search-logo" src="images/search-logo.png"/>
                        </button>
                    </li>
                    <li class="part-contain-header"></li>
                    <li class="part-contain-header"></li>
                    <li class="part-contain-header">
                        <img onclick="showNoti()" id="noti-1" class="header-icon move-right-icon" src="images/noti_unselected.png"/>
                        <img onclick="hideNoti()" id="noti-2" class="header-icon move-right-icon" src="images/noti_selected.png"/>
                    </li>
                    <li class="part-contain-header">
                        <c:url var="signOut" value="MainController">
                            <c:param name="action" value="signOut"/>
                        </c:url>
                        <img onmouseover="changeIcon()" id="sign-out-1" class="header-icon" src="images/signout_unhover.png"/>
                        <a href="${signOut}" class="default-link"><img onmouseout="changeIcon2()" id="sign-out-2" class="header-icon" src="images/signout_hover.png"/></a>
                    </li>
                    <li class="part-contain-header">
                        <img id="header-avatar" src="images/default-avatar.png"/>
                        <label id="header-fullname">
                            ${sessionScope.USER_INFO.lastname} ${sessionScope.USER_INFO.firstname}
                        </label>
                    </li>
                    <li class="part-contain-header"></li>
                    <div id="box-buying" class="box-bag">
                        <label class="noti-title">
                            Notification
                        </label>
                    </div>
                </c:if>
            </c:if>

        </nav>

    </body>
</html>

