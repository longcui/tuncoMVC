<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Login Page</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
    <script src="http://code.jquery.com/jquery.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="<c:url value="/resources/js/login.js"/>"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Tunco Order Login Form </h1>

<div id="login-box">

    <h2>Please Sign in</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form class="form-signin" name='loginForm' action="<c:url value='/login' />" method='POST'>
        <table>
            <tr>
                <%--<td >User:</td>--%>
                <td><input type='text'  class="form-control" name='username' placeholder="user name"></td>
            </tr>
            <tr>
                <%--<td>Password:</td>--%>
                <td><input type='password'  class="form-control" name='password' placeholder="password"/></td>
            </tr>
            <tr>
                <td colspan='1'>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </td>
            </tr>
        </table>

        <div style="margin-top: 10px">
            <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
            </fb:login-button>
        </div>

        <input type="hidden"
               name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<script>
    var BASE_URL = "${pageContext.request.contextPath}";        // /web
</script>
</body>
</html>