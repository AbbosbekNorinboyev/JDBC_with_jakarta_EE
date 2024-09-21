<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group update</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>

<form method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Group name</label>
        <input id="name" type="text" name="name" class="form-control" value="${build.getGroup_name()}"/>
    </div>
    <div class="mb-3">
        <label for="count" class="form-label">Student count</label>
        <input id="count" type="number" name="count" class="form-control" value="${build.getCount()}"/>
    </div>
    <button type="submit" class="btn btn-danger">Update</button>
    <a href="/" class="btn btn-warning">Back</a>
</form>

<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
