<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="project.roomreserve.*, java.util.*" %>
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
<h2 class="page-heading">Edit or Delete Rooms</h2>

    <%
        EditRoomsBusiness rb = new EditRoomsBusiness();
        List<Rooms> roomList = rb.getAllRooms();
    %>
<div class="container">
    <table>
        <tr>
            <th>ID</th>
            <th>Room Name</th>
            <th>Capacity</th>
            <th>Location</th>
            <th>Size</th>
            <th>Equipment</th>
            <th>Actions</th>
        </tr>
        <%
            for (Rooms r : roomList) {
        %>
        <tr>
            <td><%= r.getRoom_id() %></td>
            <td><%= r.getRoom_name() %></td>
            <td><%= r.getCapacity() %></td>
            <td><%= r.getLocation() %></td>
            <td><%= r.getSize() %></td>
            <td><%= r.getEquipment() %></td>
            <td>
                <form action="UpdateRooms.jsp" method="get" style="display:inline;">
                    <input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
                    <button class="btn edit-btn">Update</button>
                </form>
                <form action="DeleteRoom" method="post" style="display:inline;" onsubmit="return confirm('Are you sure?');">
                    <input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
                    <button class="btn delete-btn">Delete</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

    <footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>