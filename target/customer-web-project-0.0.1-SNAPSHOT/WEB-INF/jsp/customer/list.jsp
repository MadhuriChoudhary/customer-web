<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <!--  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<title>Customer</title>
</head>
<body>
<spring:url value="/customer/add" var="addURL"/>
<a href="${addURL}">Add New Customer</a>

<div class="container">
  <h2>Add customer</h2>
  <table class="table table-hover">
    <thead>
      <tr>
       <th>First Name</th>
       <th>Last Name</th>
       <th>Email</th>
       <th>Mobile Number</th>
       <th>Date Of Birth</th>
       <th>Address</th>
       <th colspan="2">Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
	      <tr>
	        <td>${customer.firstName }</td>
	         <td>${customer.lastName }</td>
	         <td>${customer.email }</td>
	         <td>${customer.mobileNumber }</td>
	         <td>${customer.dateOfBirth }</td>
	         <td>${customer.addressVO.addressLine1 } ${customer.addressVO.addressLine2 }</td>
	         <td><spring:url value="/customer/update/${customer.id }" var="updateURL"/><a href="${updateURL}">Update</a></td>
	         <td><spring:url value="/customer/delete/${customer.id }" var="deleteURL"/><a href="${deleteURL}">Delete</a></td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>