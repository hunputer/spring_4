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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
  <h2>${board} Write Form</h2>
  <form id="frm" action="./${board}Write" method="post" >
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
    
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
    </div> 
    
     <div class="form-group">
      <label for="contents">Contents:</label>
      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    </div>
    
    <div class="form-group">
      <label for="file">files:</label>
      <input type="file" class="form-control" id="file" name="file">
    </div>	
 
 	<input type="button" class="btn btn-primary" value="Write" id="btn">
    <button type="submit" class="btn btn-default">Write</button>
  </form>
</div>

<script type="text/javascript"  src="../resources/js/boardWrite.js"></script>

</body>
</html>