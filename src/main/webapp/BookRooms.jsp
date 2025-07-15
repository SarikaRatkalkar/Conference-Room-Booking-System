<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<div class="title">RoomReserve</div>
    
</header>
<h2>Select Date and Time</h2>
    <form action="AvailableRoomsServlet" method="post">
        Date: <input type="date" name="booking_date" required><br><br>
        Start Time: <input type="time" name="start_time" required><br><br>
        End Time: <input type="time" name="end_time" required><br><br>
        <input type="submit" value="View Rooms">
    </form>
    <footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>