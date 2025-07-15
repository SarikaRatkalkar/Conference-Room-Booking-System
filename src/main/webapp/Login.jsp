<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RoomReserve</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<div class="title">RoomReserve</div>
    
</header>
<div class="login-box">
    <h2>Login</h2>
    <form action="authenticate" method="get">
        <input type="text" name="username" placeholder="Username" required />
        <input type="password" name="password" placeholder="Password" required />

        <div class="radio-group">
            <label><input type="radio" name="role" value="admin" required> Admin Login</label>
            <label><input type="radio" name="role" value="employee" required> Employee Login</label>
        </div>

        <button type="submit" class="login-btn">Login</button>
    </form>

    <div class="register">
        New user? <a href="Registration.jsp">Register</a>
        <br>
        <%= session.getAttribute("msg")%>
    </div>
</div>
<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>