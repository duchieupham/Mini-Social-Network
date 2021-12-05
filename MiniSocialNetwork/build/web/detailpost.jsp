<%-- 
    Document   : detailpost
    Created on : Sep 29, 2020, 4:53:08 PM
    Author     : phamduchieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${requestScope.POST_DETAIL.imgURL == null || empty requestScope.POST_DETAIL}">
    <div class="content-detail-post bg-white">
        <div class="move-main-center">
            <%@include  file="contentdetailpost.jsp" %>
        </div>
    </div>
</c:if>
<c:if test="${requestScope.POST_DETAIL.imgURL != null}">
    <c:if test="${not empty requestScope.POST_DETAIL.imgURL}">
        <div class="content-detail-post">
            <img class="img-detail-post" src="images/articles/${requestScope.POST_DETAIL.imgURL}"/>
            <%@include  file="contentdetailpost.jsp" %>
        </div>
    </c:if>
</c:if>