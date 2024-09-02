<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${ 1+2}

	<p>Wow, I know a lot about you...</p>
	<p>Your name is ${param.username}/>.</p>
	<p>Your password is ${param.pw}/>.</p>
	<p>You are ${param.gender}/>.</p>

	<c:out value="Hi, there!" />
	<c:out value="${username}" default="Nobody" />
	<c:out value="${username}">Nothing</c:out>

	<c:set var="four" value="${3 + 1}" />
	<c:set var="four" scope="session" value="${3 + 	1}" />
	<c:set var="eight">
		<c:out value="${4 * 2}" />
	</c:set>
	<c:remove var="doomed" scope="session" />

	<c:choose>
		<c:when test="${num==2}">
			<li>Error 1 has occurred.</li>
		</c:when>

		<c:when test="${num==3}">
			<li>Error 2 has occurred.</li>
		</c:when>

		<c:when test="${num==4}">
			<li>Error 3 has occurred.</li>
		</c:when>

		<c:otherwise>
			<li>Everything is fine.</li>
		</c:otherwise>
	</c:choose>
	<c:import url="http://www.cnn.com"/>
	<c:import url="NewFile.jsp"/>
	

	<c:forTokens items="www.iti.gov.eg" delims="." var="site" >
		<c:out value="${site}" />
		<br>
	</c:forTokens>
	
</body>
</html>