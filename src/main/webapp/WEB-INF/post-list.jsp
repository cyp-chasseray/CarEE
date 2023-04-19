<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Categories</title>
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
            <a class="nav-link active" aria-current="page" href="posts">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="categories">Category List</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="login">Login</a>
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


<div class="container" id="card-container">
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
    <c:forEach var="p" items="${posts}">
      <div class="col">
        <div class="card">
          <img src="https://www.sauvageboris.fr/training/javaee/carEE/resources/cars/car_jaguar_f_pace.jpg" class="card-img-top" alt="${p.title}">
          <div class="card-body">
            <h5 class="card-title">${p.title}</h5>
            <h5 class="card-text">Electrique</h5>
            <button type="button" class="btn btn-success">
              <a href="${pageContext.request.contextPath}/details-car?id=${p.id}" style="color:white; text-decoration:none;">
                Details
              </a>
            </button>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<div style="background-color: #f2f2f2; padding: 40px;">
  <h1 style="text-align: center; color: black;">Our Services</h1>
  <div class="row mt-4">
    <div class="col-md-4">
      <div style="display: flex; flex-direction: column; align-items: center;">
        <p style="color: black; margin-top: 10px;">Lorem</p>
      </div>
    </div>
    <div class="col-md-4">
      <div style="display: flex; flex-direction: column; align-items: center;">
        <p style="color: black; margin-top: 10px;">Ipsum</p>
      </div>
    </div>
    <div class="col-md-4">
      <div style="display: flex; flex-direction: column; align-items: center;">
        <p style="color: black; margin-top: 10px;">Dolor</p>
      </div>
    </div>
  </div>
</div>

<div class="container" id="two-text-container">
  <div class="row">
    <div class="col-md-6">
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dapibus blandit justo eget posuere. Nunc sagittis risus eget risus lacinia, eu posuere justo consectetur. Sed ac elit vel odio laoreet rutrum. Praesent ac risus vel velit feugiat tristique. Proin consequat quam vel nibh fringilla, ac ultricies nisl congue.</p>
    </div>
    <div class="col-md-6">
      <p>Nulla aliquam velit non ex efficitur, non maximus nulla tincidunt. Cras at convallis nisi. Pellentesque sed bibendum dolor. Suspendisse quis convallis ex. In dictum ipsum vel leo lacinia, at tristique ex vestibulum. Fusce volutpat augue ac massa blandit, vel tempus velit dictum. </p>
    </div>
  </div>
</div>
<div class = "back-image-header">
  <h1 class = "back-image-title">2</h1>
  <p class = "back-image-content">cars available</p>
</div>
<div class="purchase-message-container-green">
  <p class= "purchase-message-text">What are you waiting for? Purchase a Caree now</p>
</div>
<div class = "bottom-elements">
  <div class = "bottom-singular">
    <h3>Get in touch</h3>
    <p>Phone: 00000000</p>
    <p>Email: cccccc@ccc.fr</p>
    <p>Fax: 00000000</p>
  </div>
  <div class = "bottom-singular">
    <h3>Caree is an awesome website management tool</h3>
    <p>Thank you for choosing Caree!</p>
  </div>
  <div class = "bottom-singular">
    <h3>Caree inc</h3>
    <p>France</p>
    <p>02620</p>
  </div>
</div>

</body>
</html>
