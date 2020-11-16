<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List"%>
<%@page import="by.grodno.nosevich.webapp.entities.Department"%>
<html>
   <body>
   <link rel="stylesheet"
   	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
   	crossorigin="anonymous">
      <form action = "save" method = "POST" class = "form">
         First Name: <input type = "text" name = "firstName">
         <br />
         Last Name: <input type = "text" name = "lastName" />
         <br />
         BirthDate: <input type = "date" name = "birthdate" value = "1990-01-01"/>
         <br />
         <input type="radio" id="male" name="male" value="true">
			<label for="male">Male</label><br>
		 <input type="radio" id="female" name="male" value="false">
			<label for="female">Female</label><br>
         Salary: <input type = "text" name = "salary" />
         <br />
         Department:
         <p><select multiple name="departmentId">
         <% List<Department> depts = (List<Department>) request.getAttribute("depts");
            for (Department currDept : depts){%>
                   <option value="<%=currDept.getId()%>"><%= currDept.getName() + "(" + currDept.getCity() + ")" %></option>
             <%}%>
            </select></p>
         <br />
         <input type = "submit" value = "Submit" />
      </form>
      <!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
   </body>
</html>