<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="project.roomreserve.*, java.util.*" %>
    <%
    int roomId = Integer.parseInt(request.getParameter("room_id"));
    EditRoomsBusiness rb = new EditRoomsBusiness();
    Rooms room = rb.getRoomById(roomId);
%>
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
<form class="room-form" action="UpdateRoom" method="post">
        <h2>Update Room</h2>
        <input type="hidden" name="room_id" value="<%= room.getRoom_id() %>" />
        Room Name: <input type="text" name="room_name" value="<%= room.getRoom_name() %>" required />
        Capacity: <input type="number" name="capacity" value="<%= room.getCapacity() %>" required />
        Location: <input type="text" name="location" value="<%= room.getLocation() %>" required />
        Size: <input type="text" name="size" value="<%= room.getSize() %>" required />
        Equipment: <input type="text" name="equipment" value="<%= room.getEquipment() %>" required />
        <input type="submit" value="Update Room" class="btn" />
    </form>
    </div>
<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>