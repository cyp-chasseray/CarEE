<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Form</title>
</head>
<body>
<h3>Connexion admin</h3>
<form method="post" action="login">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>

  <button type="submit">Login</button>
</form>
<button onclick="location.href='/CarEE_war_exploded/register';">Inscription</button>
</body>
</html>
