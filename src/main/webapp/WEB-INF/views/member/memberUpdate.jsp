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
	<h3>Member Update Page</h3>
	<form action="./memberUpdate" method="post">
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" value="${member.name}" name="name">
	    </div>
	    <div class="form-group">
	      <label for="email">email:</label>
	      <input type="text" class="form-control" id="email" value="${member.email}" name="email">
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>