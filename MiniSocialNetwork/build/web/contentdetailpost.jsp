<div class="content-post">
    <div class="content-scroll">
        <div class="header-post">
            <form action="MainController" method="POST">
                <button class="btn-inside-detail-post moving-down" type="submit">
                    <img class="icon-detail-inside" src="images/icon-back.png"/>
                    Back
                </button>
            </form>
            <form>
                <button class="btn-inside-detail-post moving-down2" type="submit">
                    <img class="icon-detail-inside2 move-down-icon" src="images/icon-emotion.png"/>
                    Emotion
                </button>
            </form>
            <c:if test="${sessionScope.USER_INFO.email == requestScope.POST_DETAIL.emailID}">
                <form>
                    <button class="btn-inside-detail-post moving-down3" type="submit">
                        <img class="icon-detail-inside move-down-icon" src="images/icon-delete-post.png"/>
                        Delete Post
                    </button>
                </form>
            </c:if>
            <img class="right-position moving-z right-margin" id="header-avatar" src="images/default-avatar.png"/>
            <label class="moving-z right-margin2" id="post-fullname">
                ${requestScope.POST_DETAIL.fullname}
            </label>
            <br/><br/>
            <label class="moving-z right-margin2" id="post-created-date">
                ${requestScope.POST_DETAIL.createdDate.split(":")[0]}:${requestScope.POST_DETAIL.createdDate.split(":")[1]}
            </label>
        </div>
        <div class="body-article2">
            <div class="article-title">
                ${requestScope.POST_DETAIL.title}
            </div>
            <div class="article-description insde-desc">
                ${requestScope.POST_DETAIL.description}
            </div>
            <div class="post-inside-notice">
                <label class="notice-label">
                    ${requestScope.NOTICE_POST.likeCount} 
                    <c:if test="${requestScope.NOTICE_POST.likeCount >= 2}">
                        Likes
                    </c:if>
                    <c:if test="${requestScope.NOTICE_POST.likeCount == 1}">
                        Like
                    </c:if>
                </label>
                <label class="notice-label">
                    ${requestScope.NOTICE_POST.dislikeCount}
                    <c:if test="${requestScope.NOTICE_POST.dislikeCount >= 2}">
                        Dislikes
                    </c:if>
                    <c:if test="${requestScope.NOTICE_POST.dislikeCount == 1}">
                        Dislike
                    </c:if>
                </label>
                <label class="notice-label">
                    ${requestScope.NOTICE_POST.commentCount}
                    <c:if test="${requestScope.NOTICE_POST.commentCount >= 2}">
                        Comments
                    </c:if>
                    <c:if test="${requestScope.NOTICE_POST.commentCount == 1}">
                        Comment
                    </c:if>
                </label>
                <br/>
                <div class="btn-emotion-frame">
                    <c:if test="${requestScope.EMOTION_OBJECT.like == true}">
                        <form id="liked-btn" action="MainController">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="1"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside2" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-liked.png"/>
                                Like
                            </button> 
                        </form>
                        <form id="dislike-btn" action="MainController" method="POST">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="2"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside moving-right-emotion" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-dislike.png"/>
                                Dislike
                            </button> 
                        </form>
                    </c:if>
                    <c:if test="${requestScope.EMOTION_OBJECT.like == false}">
                        <form id="like-btn" action="MainController" method="POST">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="3"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-like.png"/>
                                Like
                            </button> 
                        </form>
                        <form id="disliked-btn" action="MainController" method="POST">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="4"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside2 moving-right-emotion" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-disliked.png"/>
                                Dislike
                            </button> 
                        </form>
                    </c:if>
                    <c:if test="${requestScope.EMOTION_OBJECT.like == null || empty requestScope.EMOTION_OBJECT.like}">
                        <form id="like-btn" action="MainController" method="POST">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="5"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-like.png"/>
                                Like
                            </button> 
                        </form>
                        <form id="dislike-btn" action="MainController" method="POST">
                            <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                            <input type="hidden" name="emotionValue" value="6"/>
                            <input type="hidden" name="emotionID" value="${requestScope.EMOTION_OBJECT.emotionID}"/>
                            <button type="submit" class="btn-emotion-inside moving-right-emotion" name="action" value="makeEmotion">
                                <img class="img-emotion" src="images/icon-dislike.png"/>
                                Dislike
                            </button> 
                        </form>
                    </c:if>
                </div>        
            </div>
            <div class="article-comment-frame">
                <label class="comment-label">Comments</label>
                <c:if test="${requestScope.LIST_COMMENT != null}">
                    <c:if test="${not empty requestScope.LIST_COMMENT}">
                        <c:forEach var="comment" items="${requestScope.LIST_COMMENT}">
                            <div class="comment-content">
                                <img class="avatar-comment" src="images/default-avatar.png"/>
                                <label class="fullname-comment">${comment.fullname}</label>
                                <label class="createdDate-comment">${comment.createdDate.split(":")[0]}:${comment.createdDate.split(":")[1]}</label>
                                <div class="desc-comment">
                                    ${comment.description}
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </c:if>
            </div>

        </div>
        <div class="article-insert-comment-frame">
            <form action="MainController" method="POST">
                <input oninput="showBtnSubmitComment()" id="txtInsertCmt" class="txt-insert-comment" type="text" name="txtComent" placeholder="type comment here..."/>
                <input type="hidden" name="articleID" value="${requestScope.POST_DETAIL.postID}"/>
                <input type="hidden" name="txtEmailID" value="${sessionScope.USER_INFO.email}"/>
                <button id="btnSubmitCmt" class="btn-submit-comment" type="submit" name="action" value="postComment">Post</button>
            </form>
        </div>
    </div>
</div>
