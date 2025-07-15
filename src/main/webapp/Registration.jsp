<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RoomReserve</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<div class="title">RoomReserve</div>
    
</header>
<div class="register-box">
    <h2>User Registration</h2>
    <form action="register" method="post">
        <input type="text" name="u_fullname" placeholder="Full Name" required />
        <br>
        <br>
        <input type="email" name="u_email" placeholder="Email" required />
        <br>
        <br>
        <input type="text" name="u_username" placeholder="Username" required />
        <br>
        <br>
        <input type="password" name="u_password" placeholder="Password" required />
        <input type="hidden" name="role" value="employee">
        <br>
        <br>

        <button type="submit" class="register-btn">Register</button>
    </form>
</div>
<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>