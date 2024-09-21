<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Update</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>

<form method="post">
    <div class="mb-3">
        <label for="id" class="form-label">Group id</label>
        <input id="id" type="number" name="group_id" class="form-control"/>
    </div>
    <div class="mb-3">
        <label for="age" class="form-label">Age</label>
        <input id="age" type="number" name="age" class="form-control"/>
    </div>
    <button class="btn btn-success">Update</button>
    <a href="/" class="btn btn-warning">Back</a>
</form>

<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
