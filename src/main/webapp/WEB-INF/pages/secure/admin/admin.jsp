<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<h2>Admin View</h2>
	<h4>${message}</h4><br>
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a> &nbsp; <a href="${pageContext.request.contextPath}/home">Show landing page</a>

	<table id="listTable" width="50%" cellpadding="0" cellspacing="0"
		border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Authority</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="current" varStatus="i">
				<tr>

					<td nowrap="nowrap">${current.id} &nbsp;</td>
					<td nowrap="nowrap">${current.name} &nbsp;</td>
					<td nowrap="nowrap">${current.password} &nbsp;</td>
					<td nowrap="nowrap">${current.email} &nbsp;</td>
					<td nowrap="nowrap">${current.authority} &nbsp;</td>

					<td nowrap="nowrap">
						<a title="Create"
						href="${pageContext.request.contextPath}/home/admin/userPage">Create</a> <a
						title="Edit"
						href="${pageContext.request.contextPath}/home/editUser/${current.id}">Update</a>
						<a title="Delete"
						href="${pageContext.request.contextPath}/home/deleteUser/${current.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>