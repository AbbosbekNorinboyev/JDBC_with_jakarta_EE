<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group List</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Group name</th>
                        <th scope="col">Created at</th>
                        <th scope="col">Count</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${groupsList}" var="groupsList">
                        <tr>
                            <td><c:out value="${groupsList.getId()}"/></td>
                            <td><c:out value="${groupsList.getGroup_name()}"/></td>
                            <td><c:out value="${groupsList.getCreate_at()}"/></td>
                            <td><c:out value="${groupsList.getCount()}"/></td>
                            <td>
                                <a href="/group/delete/${groupsList.getId()}" class="btn btn-danger">Delete</a> ||
                                <a href="/group/update/${groupsList.getId()}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
