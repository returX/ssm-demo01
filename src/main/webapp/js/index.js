var slideLeft = function(){
	$("#left").animate({
		width:'toggle'
	});
}

var slideRight = function(){
	$("#right").animate({
		width:'toggle'
	});
}

var loginAction = function () {
	var username = $("#username-login").val();
	var password = $("#password-login").val();

	$.ajax({
		type:"post",
		url:"/login",
		data:JSON.stringify({
			"username" : username,
			"password" : password
		}),
		contentType:"application/json;charset=utf-8",
		error:function (error) {
			alert("出错啦！");
			console.log(error);
		},
		success:function (data) {
			if(data == "success"){
				window.location.href = "/main.jsp";
			}else {
				alert("账号或密码错误");
			}
		}
	})
}

var createOption = function(num){
    var option = document.createElement("option");
    var select = $("#ageSelect");
    option.setAttribute("name","age");
    option.setAttribute("value",num);
    option.innerHTML = num;
    select.append(option);
}
$(document).ready(function(){
	$(".login").click(slideLeft);
	$(".register").click(slideRight);
	$(".left-icon").click(slideLeft);
	$(".right-icon").click(slideRight);
    for (var i = 1; i < 120; i++) {
        createOption(i);
    }
    

});