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

<h2>Welcome, Employee!</h2>

<div class="dashboard-buttons">
    <form action="BookRooms.jsp"><button>Book Room</button></form>
    <br>
    <form action="ViewBookedRooms" method="get"><button type="submit">View Booked Rooms</button></form>
    <br>
    <form action="ViewBookedRooms" method="get"><button type="submit">Cancel Booking</button></form>
</div>


<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>