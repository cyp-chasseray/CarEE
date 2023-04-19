<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<h3>Inscription admin</h3>
<form method="post" action="register">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="password">Please confirm your password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
    <button type="submit">Inscription</button>
</form>
</body>
</html>

