<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group delete</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-0 m-5">
    <div class="alert alert-danger">
        <h1>Are you sure delete this group <i><c:out value="${build.getGroup_name()}"/></i>?</h1>
    </div>
    <button type="submit" class="btn btn-warning">Yes</button>
    <a href="/" class="btn btn-success">Back</a>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
