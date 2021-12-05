/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



window.addEventListener("scroll", function () {
    let createPostLeftSide = document.getElementById("createPostLeftSide");
    var scrollY = this.scrollY;
    if (scrollY > 200) {
        createPostLeftSide.style.display = "block";
    } else {
        createPostLeftSide.style.display = "none";
    }
});

$(function () {
    let slidebarBtn = $(".open-slidebar");
    let contentSlidebar = $(".content-slide-bar-article");
    slidebarBtn.on('click', function () {
        var index = $(".open-slidebar").index(this);
        if (contentSlidebar[index].style.display === "" || contentSlidebar[index].style.display === null) {
            contentSlidebar[index].style.display = "none";
        }
        if (contentSlidebar[index].style.display === "none") {
            contentSlidebar[index].style.display = "block";
        } else {
            contentSlidebar[index].style.display = "none";
        }
    });
});

$(function () {
    let btnCreatePost = $(".btnCreatePost");
    let cancelCreatePost = $("#cancelCreatePost");
    let createPostFrame = document.getElementById("create-post-frame");
    btnCreatePost.on('click', function () {
        createPostFrame.style.display = "block";
    });
    cancelCreatePost.on('click', function () {
        createPostFrame.style.display = "none";
    });
});

$(function () {
    let slidebarBtn = $(".open-slidebar");
    let d1s = $(".d1-icon");
    let d2s = $(".d2-icon");
    slidebarBtn.on('mouseover', function () {
        var index = $(".open-slidebar").index(this);
        d1s[index].style.display = "none";
        d2s[index].style.display = "block";
    });
    slidebarBtn.on('mouseout', function () {
        var index = $(".open-slidebar").index(this);
        d1s[index].style.display = "block";
        d2s[index].style.display = "none";
    });
});

function showLbEmail() {
    var label = document.getElementById("lbEmail");
    label.style.display = "block";
    label.style.transform = "translateX(65px)translateY(45px)";
}

function hideLbEmail() {
    var label = document.getElementById("lbEmail");
    var textfield = document.getElementById("txtEmail");
    if (textfield.value == "" || textfield.value == null) {
        label.style.transform = "translateX(65px)translateY(75px)";
    }
}

function showLbPassword() {
    var label = document.getElementById("lbPassword");
    label.style.display = "block";
    label.style.transform = "translateX(65px)translateY(45px)";
}

function hideLbPassword() {
    var label = document.getElementById("lbPassword");
    var textfield = document.getElementById("txtPassword");
    if (textfield.value == "" || textfield.value == null) {
        label.style.transform = "translateX(65px)translateY(75px)";
    }
}

function showNoti() {
    var icon = document.getElementById("noti-1");
    var icon2 = document.getElementById("noti-2");
    var box = document.getElementById("box-buying");
    box.style.display = "block";
    icon.style.display = "none";
    icon2.style.display = "block";

}

function hideNoti() {
    var icon = document.getElementById("noti-1");
    var icon2 = document.getElementById("noti-2");
    var box = document.getElementById("box-buying");
    box.style.display = "none";
    icon.style.display = "block";
    icon2.style.display = "none";

}

function changeIcon() {
    var icon = document.getElementById("sign-out-1");
    var icon2 = document.getElementById("sign-out-2");
    icon.style.display = "none";
    icon2.style.display = "block";
}

function changeIcon2() {
    var icon = document.getElementById("sign-out-1");
    var icon2 = document.getElementById("sign-out-2");
    icon.style.display = "block";
    icon2.style.display = "none";
}

function showBtnCommentSubmitOutside() {
    var textfields = document.getElementsByClassName("comment-outside-textfield");
    var buttons = document.getElementsByClassName("comment-outside-submit");
    for (var i = 0; i < textfields.length; i++) {
        if (textfields[i].value === null || textfields[i].value === "") {
            buttons[i].style.display = "none";
        } else {
            buttons[i].style.display = "block";
        }
    }
}

function showBtnSubmitComment() {
    var txtInsert = document.getElementById("txtInsertCmt");
    var btnSubmitCmt = document.getElementById("btnSubmitCmt");
    if (txtInsert.value === null || txtInsert.value === "") {
        btnSubmitCmt.style.display = "none";
    } else {
        btnSubmitCmt.style.display = "block";
    }
}

//
//function test(){
//    var x = document.getElementsByClassName("sss");
//    x[1].style.display
//}