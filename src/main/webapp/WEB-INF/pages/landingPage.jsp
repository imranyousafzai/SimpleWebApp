<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<h2>This is landing page</h2>
	${message}<br>
	<c:choose>
		<c:when test="${isAdmin}">
			<a href="home/showUsers"> Users </a>
		</c:when>
	</c:choose>
	<br><a href="<c:url value="/j_spring_security_logout" />"> Logout</a>

</body>
</html>