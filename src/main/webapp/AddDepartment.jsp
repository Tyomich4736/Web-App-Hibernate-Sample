<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
   <body>
      <form action = "save" method = "POST" class = "form">
         Name: <input type = "text" name = "name">
         <br />
         City: <input type = "text" name = "city" />
         <br />
         <input type = "submit" value = "Submit" />
      </form>
      <!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
   </body>
</html>