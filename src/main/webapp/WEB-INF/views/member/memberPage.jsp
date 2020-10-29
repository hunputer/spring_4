<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>memberSelect</h3>
  <h3>id : ${member.id}</h3>
  <h3>pw : ${member.pw}</h3>
  <h3>name : ${member.name}</h3>
  <h3>email : ${member.email}</h3>
  <div>
  <img alt="" src="../resource/upload/member/${file.fileName}">
  </div>
</div>

<input type="button" title="${dto.num}" value="Update" id="update" class="btn btn-warning">
<input type="button" title="${dto.num}" value="delete" id="delete" class="btn btn-warning">

<script type="text/javascript">
	$("#update").click(function(){
		location.href ="./memberUpdate";
	})
	
	$("#delete").click(function(){
		location.href = "./memberDelete";
	})
</script>

</body>
</html>