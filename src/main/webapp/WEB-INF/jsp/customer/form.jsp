<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<title>Customer</title>
</head>
<body>
<div class="container">
 <h2>Customer Form</h2>
 <spring:url value="/customer/save" var="saveURL"/>
<form:form action="${saveURL }" method="POST" modelAttribute="customerForm">
 <form:hidden path="id"/>
  <form:hidden path="addressVO.id"/>
<table>
	<tr>
		<td>First Name : </td>
		<td><form:input path="firstName"/></td>
	</tr>
	<tr>
		<td>Last Name : </td>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td>Gender : </td>
         <td>
	         <form:select path="genderVO.id">
                <c:forEach items="${genders}" var="gender">
                            <option value="${gender.id}">${gender.name}</option>
                </c:forEach>
              </form:select>
		</td> 
	</tr>
	<tr>
		<td>Date of Birth : </td>
		<td><form:input path="dateOfBirth"/></td>
	</tr>
	<tr>
		<td>Mobile Number : </td>
		<td
		><form:input path="mobileNumber"/></td>
	</tr>
	<tr>
		<td>Email : </td>
		<td><form:input path="email"/></td>
	</tr>
	
	<tr>
        <td>Address:</td>
        <td></td>
	</tr>
	<tr>
        <td>Address Line 1 :</td>
        <td><form:input path="addressVO.addressLine1"/></td>
	</tr>
	<tr>
        <td>Address Line 2 :</td>
        <td><form:input path="addressVO.addressLine2"/></td>
	</tr>
	<tr>
        <td>Postcode :</td>
        <td><form:input path="addressVO.postcode"/></td>
	</tr>
	<tr>
        <td>Town :</td>
        <td><form:input path="addressVO.town"/></td>
	</tr>
	<tr>
        <td>Country :</td>
        <td><form:input path="addressVO.country"/></td>
	</tr>
	<tr>
		<td>Username : </td>
		<td><form:input path="userName" readonly="${readonly}"/></td>
	</tr>
	<tr>${readonly}**
		<td>Password : </td>
		<td><form:password path="password" readonly="${readonly}"/></td>
	</tr>
	<tr>
		<td> </td>
		<td><button type="submit" >Save</button> </td>
	</tr>
</table>
</form:form>
</div>



</body>
</html>