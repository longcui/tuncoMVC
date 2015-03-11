<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>

    <style>
        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<h2>Registration Form</h2>

<form:form method="POST" modelAttribute="user">
    <table>
        <tr>
            <td><label for="name">Name: </label> </td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label for="email">Email: </label> </td>
            <td><form:input path="email" id="email"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

          <tr>
            <td colspan="3"><input type="submit" value="Register"/></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
<br/>
<br/>
</body>
</html>