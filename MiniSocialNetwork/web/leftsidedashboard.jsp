<%-- 
    Document   : leftsidedashboard
    Created on : Sep 29, 2020, 5:31:33 PM
    Author     : phamduchieu
--%>
<div id="createPostLeftSide" class="content-create-post-scrolling">
    <c:if test="${applicationScope.SESSION_IN_DAY >= 6 && applicationScope.SESSION_IN_DAY <= 17}">
        <img class="icon-daynight2" src="images/icon-day.png"/>
    </c:if>
    <c:if test="${applicationScope.SESSION_IN_DAY >= 18 || applicationScope.SESSION_IN_DAY <= 5}">
        <img class="icon-daynight2" src="images/icon-night.png"/>
    </c:if>
    <label class="current-date-desc2">
        ${applicationScope.CURRENT_TIME}
    </label>
    <div class="create-post-round btnCreatePost">
        <img class="icon-create-post-small" src="images/create-post-icon.png"/>
    </div>
</div>