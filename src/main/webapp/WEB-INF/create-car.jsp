<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 19/04/2023
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>This is the car creation page (design in progress)</h1>
<form method="post" action="create-car">

  <label for="title">Car name:</label>
  <input type="text" id="title" name="title">

  <label for="content">Car description:</label>
  <input type="text" id="content" name="content">

  <label for="price">Price:</label>
  <input type="number" id="price" name="price">

  <label for="category">Category:</label>
  <input type="text" id="category" name="category">

  <label for="pictureUrl">Picture URL:</label>
  <input type="text" id="pictureUrl" name="pictureUrl">

  <input type="submit" value="Submit">
</form>
</body>
</html>
