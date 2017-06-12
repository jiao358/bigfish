<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CMB Engine</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<!-- 代码开始 -->

<div class="wrapper">
	<div class="container">
		<h1>欢迎登陆</h1>
		
		<form class="form">
			<input id="user" type="text" value='estela' placeholder="用户名">
			<input id="password" type="password" value ='123456' placeholder="密码">
			<button type="submit" id="login-button">登陆</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>
<form id='sform' method="post">
	<input id="suser" type='text' /> 
	<input id="skey" type='text' /> 
	
</form>

<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
/* $('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
 */
 $(window).load(function() {
	 $('#sform').hide();
 });
 
$('#login-button').click(function(event){
	event.preventDefault();
	$.ajax({ 
		　　url : "/bigfish/login.do",
		　　type : "post",
		　　dataType : "json",
		　　data: {
		　　　　user: $("#user").val(),
		　　　　password: $("#password").val() 
		　　},
		　　success : function(msg) {
				$('form').fadeOut(500);
				$('.wrapper').addClass('form-success');
				if(msg.state==0){
					alert("please check your username/password");
					window.location.reload();
				}else if(msg.state==1){
					successlo(msg.sessionKey,$("#user").val());
				}
				
			
		　　}
		});
	
});

 function successlo(sessionkey,username){
/* 	 var options = {
             url: '/bigfish/loginsuccess.do',
             type: 'post',
             dataType: 'json',
             data: {
 			　　　　user: username,
 			　　　　key: sessionkey
 			　　},
             success: function (data) {
                 if (data.length > 0)
                     $("#responseText").text(data);
             }
         };
	 	$.ajax(options); */
	 	//alert(sessionkey+username);
	 	$('#sform').attr('action','/bigfish/loginsuccess.do');

	 	document.getElementById("skey").value=sessionkey;
	 	
	 	$('#sform').submit();
	 	
		
 }

</script>
<!-- 代码 结束 -->
<div style="text-align:center;font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
	
	</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>