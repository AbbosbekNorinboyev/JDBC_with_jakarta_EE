<%--
  Created by IntelliJ IDEA.
  User: norin
  Date: 12/28/2023
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Group</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>

<form method="post">
    <div class="mb-3 mt-0 m-5">
        <label for="name" class="form-label">Group name</label>
        <input id="name" type="text" name="name" class="form-control"/>
    </div>
    <div class="mb-3 mt-0 m-5">
        <label for="count" class="form-label">Student count</label>
        <input id="count" type="number" name="count" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-success mt-0 m-5">Save</button>
</form>

<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
