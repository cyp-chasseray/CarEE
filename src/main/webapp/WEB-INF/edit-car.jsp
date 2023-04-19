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
<h1>This is edit/delete car page</h1>
<form method="post" action="edit-car">

  <label for="id">Post ID:</label>
  <input type="text" id="id" name="id" value="${post.id}">

  <label for="title">Title:</label>
  <input type="text" id="title" name="title" value="${post.title}">

  <label for="content">Content:</label>
  <input type="text" id="content" name="content" value="${post.content}">

  <label for="price">Price:</label>
  <input type="number" id="price" name="price" value="${post.price}">

  <label for="category">Category:</label>
  <input type="text" id="category" name="category" value="${category.name}">

  <label for="pictureUrl">Picture URL:</label>
  <input type="text" id="pictureUrl" name="pictureUrl" value="${post.pictureUrl}">

  <label for="choice">Deletion:</label>
  <input type="text" id="choice" name="choice" placeholder="type delete to delete">

  <input type="submit" value="Submit">
</form>
</body>
</html>
