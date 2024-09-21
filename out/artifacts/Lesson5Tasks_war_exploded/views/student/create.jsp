<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student create</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>

<form method="post">
    <div class="mb-3 mt-0 m-5">
        <label for="name" class="form-label">Full name</label>
        <input id="name" type="text" name="name" class="form-control"/>
    </div>
    <div class="mb-3 mt-0 m-5">
        <label for="id" class="form-label">Group id</label>
        <input id="id" type="number" name="group_id" class="form-control"/>
    </div>
    <div class="mb-3 mt-0 m-5">
        <label for="age" class="form-label">Age</label>
        <input id="age" type="number" name="age" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-success mt-0 m-5">Save</button>
</form>

<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
