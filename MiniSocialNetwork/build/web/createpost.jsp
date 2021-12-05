<%-- 
    Document   : create-post
    Created on : Sep 29, 2020, 2:19:31 PM
    Author     : phamduchieu
--%>

<div id="create-post-frame">
    <div class="post-insert-content">
        <img class="avatar-default" src="images/default-avatar.png"/>
        <label class="desc-title">What's on your mind?</label>
        <input class="insert-title" type="text" placeholder="Post title here"/>
        <textarea class="insert-desc"></textarea>
        <div class="add-img-frame">
            <button class="add-img-btn">
                <img class="add-img-icon-btn" src="images/img-icon.png"/>Add Image
            </button>
            <img id="img-show" class="add-img-btn" src=""/>
        </div>
        <button id="cancelCreatePost" class="article-inside-submit">Cancel</button>
        <input class="article-inside-submit" type="submit" value="Post Article" />
    </div>
</div>