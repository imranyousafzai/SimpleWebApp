<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<h1>Access is denied</h1>
	<h3>You are not Authorized for this operation. Please Contact your Admin.</h3><br>
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>  &nbsp;  <a href="${pageContext.request.contextPath}/home">Show landing page</a>
</body>
</html>