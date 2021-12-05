<%-- 
    Document   : dashboard
    Created on : Sep 19, 2020, 10:42:02 PM
    Author     : phamduchieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <link href="./css/cascadingStyleSheet.css" rel="stylesheet" type="text/css">
        <script src="./js/javascript.js" type="text/javascript"></script>
        <title>Social Network - Dashboard</title>
    </head>
    <body>
        <nav class="nav-body nav-body-dashboard bg-quite-gray">
            
            <!--            <img class="bg-login" src="images/bg-blur.png"/>-->
            <c:if test="${requestScope.POST_DETAIL == null || empty requestScope.POST_DETAIL}">
                <div id="dashboard">
                    <%@include  file="createpost.jsp" %>
                    <%@include  file="leftsidedashboard.jsp" %>
                    <nav class="content-body">
                        <div class="content-create-post btnCreatePost">
                            <c:if test="${applicationScope.SESSION_IN_DAY >= 6 && applicationScope.SESSION_IN_DAY <= 17}">
                                <img class="icon-daynight" src="images/icon-day.png"/>
                            </c:if>
                            <c:if test="${applicationScope.SESSION_IN_DAY >= 18 || applicationScope.SESSION_IN_DAY <= 5}">
                                <img class="icon-daynight" src="images/icon-night.png"/>
                            </c:if>
                            <label class="current-date-desc">
                                ${applicationScope.CURRENT_TIME}
                            </label><br/>
                            <label class="ask-post">
                                How's your today, ${sessionScope.USER_INFO.firstname}?
                            </label>
                            <img class="icon-create-post" src="images/create-post-icon.png"/>
                        </div>
                        <c:if test="${requestScope.LIST_POST != null}">
                            <c:if test="${not empty requestScope.LIST_POST}">
                                <c:forEach var="article" varStatus="articleCounter" items="${requestScope.LIST_POST}">
                                    <div class="content-article">
                                        <div class="open-slidebar">
                                            <img class="detail-icon d1-icon" src="images/detail-icon.png"/>
                                            <img class="detail-icon d2-icon" src="images/detail-hover-icon.png"/>
                                        </div>
                                        <div class="content-slide-bar-article">
                                            <c:url var="detailPost" value="MainController">
                                                <c:param name="action" value="detailPost"/>
                                                <c:param name="articleID" value="${article.postID}"/>
                                            </c:url>
                                            <a class="default-link link1 link-detail-post" href="${detailPost}">
                                                <img class="icon-slidebar" src="images/icon-detail-post.png"/>
                                                Detail Post
                                            </a><br/>
                                            <c:if test="${sessionScope.USER_INFO.email == article.emailID}">
                                                <a class="default-link link1" href="">
                                                    <img class="icon-slidebar" src="images/icon-delete-post.png"/>
                                                    Delete Post
                                                </a><br/>
                                            </c:if>
                                            <!--                                    <a class="default-link link1"  href="">
                                                                                    <img  class="icon-slidebar" src="images/icon-clear.png"/>
                                                                                    Close
                                                                                </a>-->
                                        </div>
                                        <div class="header-article">
                                            <img class="right-position" id="header-avatar" src="images/default-avatar.png"/>
                                            <label id="post-fullname">
                                                ${article.fullname}
                                            </label>
                                            <br/><br/>
                                            <label id="post-created-date">
                                                ${article.createdDate.split(":")[0]}:${article.createdDate.split(":")[1]}
                                            </label>
                                        </div>
                                        <div class="body-article">
                                            <div class="article-title">
                                                ${article.title}
                                            </div>
                                            <div class="article-description">
                                                ${article.description}
                                            </div>
                                            <c:if test="${article.imgURL != null}">
                                                <c:if test="${not empty article.imgURL}">
                                                    <img class="article-img" src="images/articles/${article.imgURL}"/>
                                                </c:if>
                                            </c:if>
                                            <c:forEach var="notice" varStatus="noticeCounter" items="${requestScope.LIST_NOTICE}">
                                                <c:if test="${noticeCounter.count == articleCounter.count}">
                                                    <div class="article-notice">
                                                        <div class="notice-frame">
                                                            <img class="icon-notice" src="images/icon-like.png"/>
                                                            <label class="counting-notice color-default">${notice.likeCount}</label>
                                                        </div>
                                                        <div class="notice-frame">
                                                            <img class="icon-notice" src="images/icon-dislike.png"/>
                                                            <label class="counting-notice color-default">${notice.dislikeCount}</label>
                                                        </div>
                                                        <div class="notice-frame">
                                                            <img class="icon-notice" src="images/icon-comment.png"/>
                                                            <label class="counting-notice color-default">${notice.commentCount}</label>
                                                        </div>
                                                        <input oninput="showBtnCommentSubmitOutside()" class="comment-outside-textfield" type="text" placeholder="Add a comment"/>
                                                        <input class="comment-outside-submit" type="submit" value="Post" />
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </c:if>
                    </nav>
                </div>
            </c:if>
            <c:if test="${requestScope.POST_DETAIL != null}">
                <c:if test="${not empty requestScope.POST_DETAIL}">
                    <div id="detail-post">
                        <%@include file="detailpost.jsp" %>  
                    </div>  
                </c:if>
            </c:if>
        </nav>
    </body>
</html>
