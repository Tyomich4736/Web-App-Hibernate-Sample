<%@page import="by.grodno.nosevich.webapp.entities.User"%>
<%@page import="by.grodno.nosevich.webapp.entities.Department"%>
<%@page import="by.grodno.nosevich.webapp.service.DepartmentService"%>
<%@page import=" static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<br />

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Num</th>
					<th scope="col">Firstname</th>
					<th scope="col">Lastname</th>
					<th scope="col">Birthdate</th>
					<th scope="col">Salary</th>
					<th scope="col">Sex</th>
					<th scope="col">Department</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<%  List<User> users = (List<User>) request.getAttribute("users");
			    for (int i = 0; i<users.size(); i++){
			    User currUser = users.get(i);%>
				<tr>
					<td scope="row"><%= i+1 %></td>
					<td><%= currUser.getFirstName() %></td>
					<td><%= currUser.getLastName() %></td>
					<td>
                        <%
							Date userBirth = currUser.getBirthdate();
							String date = new SimpleDateFormat("yyyy-MM-dd").format(userBirth);
									out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
						%>

					</td>
					<td><%= currUser.getSalary() %></td>
					<td><%= currUser.isMale()? "Male":"Female"%></td>
					<td><%= currUser.getDepartment().getName()+"("+currUser.getDepartment().getCity()+")" %></td>
					<td><a class="btn btn-danger"
						href="http://localhost:8080/WebAppSample/users/delete?id=<%=currUser.getId()%>">Delete
							user</a>
				</tr>
			<%}%>
		</table>

	<a class="btn btn-primary"
		href="http://localhost:8080/WebAppSample/users/add">Add user</a>
	<br />
	<br />
	<table class="table">
    			<thead class="thead-dark">
    				<tr>
    					<th scope="col">Num</th>
    					<th scope="col">Name</th>
    					<th scope="col">City</th>
    					<th scope="col">Actions</th>
    				</tr>
    			</thead>
    			<%  List<Department> depts = (List<Department>) request.getAttribute("depts");
    			    for (int i = 0; i<depts.size(); i++){
    			    Department currDept = depts.get(i);%>
    				<tr>
    					<td scope="row"><%= i+1 %></td>
    					<td><%= currDept.getName() %></td>
    					<td><%= currDept.getCity() %></td>
    					<td>
    					<% if (!getDepartmentService().userContainsDepartment(currDept)){ %>
    					<a class="btn btn-danger"
    						href="http://localhost:8080/WebAppSample/depts/delete?id=<%=currDept.getId()%>">Delete
    							department</a>
    							<%} else {%>
    							Unable to delete
    							<%}%>
    				</tr>
    			<%}%>
    		</table>
    			<a class="btn btn-primary"
                    href="http://localhost:8080/WebAppSample/depts/add">Add Department</a>
	<br />
</body>
</html>
