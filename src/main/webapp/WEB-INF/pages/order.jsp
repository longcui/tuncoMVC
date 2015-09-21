<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tunco Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
</head>
<body>
<h1>Hello,
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        ${pageContext.request.userPrincipal.name}
    </c:if>
</h1>

<h1>Welcome to Tunco!</h1>


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

    <label>Name:</label>
    <input type="text" id="name">

    <label>Email:</label>
    <input type="text" id="email">

    <label>Telephone:</label>
    <input type="text" id="telephone">

    <div class="form-group">
        <label for="compositeDishName">Select Dish:</label>
        <select class="form-control" id="compositeDishName">
        </select>
    </div>

    <div class="form-group">
        <label for="vegetableName">Select vegetable:</label>
        <select multiple class="form-control" id="vegetableName">
        </select>
    </div>

    <div class="form-group">
        <label for="drinkName">Select Drink:</label>
        <select  multiple class="form-control" id="drinkName">
        </select>
    </div>

    <br/>
    <button class="btn btn-success btn-large " id="order">Order</button>

<script>
    var BASE_URL = "${pageContext.request.contextPath}";
    var CSRF = '${_csrf.token}';
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/order.js"/>"></script>
<c:url value="/logout" var="logoutUrl"/>

<!-- csrt support -->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</body>
</html>