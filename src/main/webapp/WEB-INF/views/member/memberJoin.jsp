<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	.member1{
		color: red;
	}
	
	.member2{
		color: blue;
	}
</style>

</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>Member Join Page</h3>
	<form action="./memberJoin" method="post" id="frm" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
	      <div id="idResult"></div>
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	     <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	      <div id="pwResult"></div>
	    </div>
	    
	   <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	      <div class="emptyResult"></div>
	    </div>
	    
	   <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	      <div class="emptyResult"></div>
	    </div>
	    
	    <div class="form-group">
	      <label for="Photo">Photo:</label>
	      <input type="file" class="form-control" id="photo" name="photo">
	    </div>
	    
	    <input type="button" id="join" value="Join" class="btn btn-default">
	    <button>Test Join</button>
  </form>
</div>

<script type="text/javascript">
	$("#id").blur(function(){
		var id = $("#id").val();
		$.post("./memberFind", {id : id} ,function(data){
			data = data.trim();
			if(data == '0'){
				$("#idResult").html("중복된 아이디 입니다.");
				$("#idResult").removeClass("member2").addClass("member1");
			}else if(id == ""){
				$("#idResult").html("아이디를 입력하세요!!");
				$("#idResult").removeClass("member2").addClass("member1");
			}else{
				$("#idResult").html("사용 가능한 아이디 입니다.");
				$("#idResult").removeClass("member1").addClass("member2");
			}
		});
	});
	
	$("#pw2").blur(function(){
		var pw = $("#pw").val();
		var pw2 = $("#pw2").val();
		if(pw != pw2){
			$("#pwResult").html("pw가 다릅니다.");
			$("#pwResult").removeClass("member2").addClass("member1");
		}else if(pw2 == ""){
			$("#pwResult").html("비밀번호를 입력하세요!");
			$("#pwResult").removeClass("member2").addClass("member1");
		}else{
			$("#pwResult").html("pw가 같습니다.");
			$("#pwResult").removeClass("member1").addClass("member2");
		}
	})
	
	$("#join").click(function(){
		var idResult = $("#idResult").html();
		var pwResult = $("#pwResult").html();
		var name = $("#name").val();
		var email = $("#email").val();
		if(idResult == "사용 가능한 아이디 입니다." && pwResult == "pw가 같습니다." && name != "" && email != ""){
			$("#frm").submit();
		}
	})
</script>

</body>
</html>