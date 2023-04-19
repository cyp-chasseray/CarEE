<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>This is a title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        <%@include file="/css/styles.css" %>
    </style>
</head>
<body>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <div>
                <img src="https://www.sauvageboris.fr/training/javaee/carEE/resources/logo/logo_car_60.png"/>
            </div>
            <div class="text-end">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="secured">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="secured/categories">Category List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="secured/create-car">Car Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="secured/create-category">Category Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="secured/logout">Logout</a>
                    </li>
                    <li>
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="create-car-container">
    <button type="button" class="btn btn-success">
        <a class = "btn-content" href="${pageContext.request.contextPath}/secured/create-car">
            Create new car
        </a>
    </button>
</div>

<div class="container-cards">
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="p" items="${posts}">
            <div class="col">
                <div class="card">
                    <img src=${p.pictureUrl} class="card-img-top" alt="${p.title}">
                    <div class="card-body">
                        <h5 class="card-title">${p.title}</h5>
                        <p class="card-text">${p.content}</p>
                        <p class="post-number">Electric</p>
                        <button type="button" class="btn btn-success">
                            <a class = "btn-content" href="${pageContext.request.contextPath}/details-car?id=${p.id}">
                                Details
                            </a>
                        </button>
                        <button type="button" class="btn btn-danger">
                            <a href="${pageContext.request.contextPath}/secured/edit-car?id=${p.id}" style="color:white; text-decoration:none;">
                                Edit
                            </a>
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
