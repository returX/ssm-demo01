
var commit_comment = function (author_id){
    var content = $("#container-comment textarea").val();
    var author_id = author_id;

    $.ajax({
        type:"post",
        url:"/getComment",
        data:JSON.stringify({
            "content" : content,
            "author_id":author_id
        }),
        contentType:"application/json;charset=utf-8",
        success:function () {
            window.location.reload();
        },
        error:function () {
            alert("出错了");
        }
    })
}

var showform = function(){
    document.getElementById("container-reply").style.display = null;
}

var commit_reply = function(comment_id,author_id){
    var content = $("#container-reply textarea").val();
    var author_id = author_id;
    var comment_id = comment_id;

    $.ajax({
        type:"post",
        url:"/getReply",
        data:JSON.stringify({
            "author_id":author_id,
            "content" : content,
            "comment_id":comment_id
        }),
        contentType:"application/json;charset=utf-8",
        success:function () {
            window.location.reload();
        },
        error:function () {
            alert("出错了");
        }
    })
}



$(document).ready(function () {
})