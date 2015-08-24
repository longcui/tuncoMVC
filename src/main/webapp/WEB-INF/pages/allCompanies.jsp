<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Company List</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Companies</h2>
<table>
    <tr>
        <td>ID</td><td>NAME</td><td>EMAIL</td><td>TELEPHONE</td><td>ADDRESS</td><td><b>X</b></td>
    </tr>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.email}</td>
            <td>${company.telephone}</td>
            <td>${company.address}</td>
            <td><a href="<c:url value='/deleteCompany_${company.id}' />"><b>x</b></a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/newCompany' />">Add New Company</a>
</body>
</html>