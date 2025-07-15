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
<div class="container">
    <h2>Add New Room</h2>
    <form action="AddRooms" method="post" class="room-form">

        <label for="room_name">Room Name:</label>
        <input type="text" id="room_name" name="room_name" required>

        <label for="capacity">Capacity:</label>
        <input type="number" id="capacity" name="capacity" required>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>

        <label for="size">Size (in sq ft):</label>
        <input type="text" id="size" name="size" required>

        <label for="equipment">Equipments (comma-separated):</label>
        <textarea id="equipment" name="equipment" rows="3" required></textarea>

        <button type="submit" class="btn">Add Room</button>
    </form>
</div>

<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>