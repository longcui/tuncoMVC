<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tunco Admin Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Hello,
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        ${pageContext.request.userPrincipal.name}
    </c:if>
</h1>

<h1>Welcome to Tunco!</h1>
<table id="allOrders" class="table table-hover">
    <thead>
    <tr>
        <th rowspan="2">Id</th>
        <th rowspan="2">Order Time</th>
        <th rowspan="2">Oder Email</th>
        <th style="text-align: center" colspan="6">Items</th>       <%--not align=--%>
        <th rowspan="2">Total price</th>
        <th rowspan="2">Order Status</th>
    </tr>
    <tr>
        <th>Name</th>
        <th>noodleType</th>
        <th>proteinType</th>
        <th>sauceType</th>
        <th>toppingType</th>
        <th>takeAway</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <div align="right" style="position:static">
        <h2>
                ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </div>
</c:if>

</body>
</html>


<script>
    var BASE_URL = "${pageContext.request.contextPath}";
    var CSRF = '${_csrf.token}';
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/allOrders.js"/>"></script>
<c:url value="/logout" var="logoutUrl"/>

<!-- csrt support -->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</body>
</html>