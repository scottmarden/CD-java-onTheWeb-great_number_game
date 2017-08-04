<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="static/stylesheets/style.css">
	<title>Insert title here</title>
</head>
<body>
	<h1>Shall we play a game?</h1>
	<h3>Try to guess what number I'm thinking of!</h3>
	
	<div id="results">
	
		<c:if test="${result == 'low'}">
			<div class="incorrect">
				<h4><c:out value="${guess}"/> is too low!</h4>
			</div>
		</c:if>
		<c:if test="${result == 'high'}">
			<div class="incorrect">
				<h4><c:out value="${guess}"/> is too high!</h4>
			</div>
		</c:if>
		<c:if test="${result == 'correct'}">
			<div class="correct">
				<h4><c:out value="${guess}"/> is correct!</h4>		
			</div>
			<a href="reset">Play again!</a>
		</c:if>
	</div>
	<c:if test="${result != 'correct'}">
	<div id="guesses">
		<form action="game" method="get">
			<label for="guess">Guess: </label><input type="text" name="guess"> 
			<button type="submit">Make a guess!</button>
		</form>
	</div>
	</c:if>
</body>
</html>