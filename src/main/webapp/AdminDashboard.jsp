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

<h2 style="text-align:center;">Welcome, Admin!</h2>

<div class="dashboard-buttons">
    <form action="AddRooms.jsp"><button>Add Room</button></form>
    <br>
    <form action="EditRooms.jsp"><button>Update Room</button></form>
    <br>
    <form action="EditRooms.jsp"><button>Delete Room</button></form>
    <br>
    <form action="ViewAllBookings" method="get"><button type="submit">View Bookings</button></form>

</div>

<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>