<%@ page import="java.util.*, project.roomreserve.*" %>
<%@ page session="true" %>
<%
    List<Rooms> availableRooms = (List<Rooms>) session.getAttribute("availableRooms");
    String booking_date = (String) session.getAttribute("booking_date");
    String start_time = (String) session.getAttribute("start_time");
    String end_time = (String) session.getAttribute("end_time");
%>
<html>
<head>
    <title>Available Rooms</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<div class="title">RoomReserve</div>
    
</header>
    <h2>Available Rooms on <%= booking_date %> from <%= start_time %> to <%= end_time %></h2>

    <%
        if (availableRooms != null && !availableRooms.isEmpty()) {
            for (Rooms r : availableRooms) {
    %>
    <div class="room-card">
        <strong>Room:</strong> <%= r.getRoom_name() %><br>
        <strong>Location:</strong> <%= r.getLocation() %><br>
        <strong>Capacity:</strong> <%= r.getCapacity() %><br>
        <strong>Size:</strong> <%= r.getSize() %><br>
        <strong>Equipment:</strong> <%= r.getEquipment() %><br><br>

        <form action="BookRoom" method="post">
            <input type="hidden" name="room_id" value="<%= r.getRoom_id() %>">
            <input type="hidden" name="booking_date" value="<%= booking_date %>">
            <input type="hidden" name="start_time" value="<%= start_time %>">
            <input type="hidden" name="end_time" value="<%= end_time %>">
            
            <%-- Generate checkboxes from available equipment --%>
            <% String[] equipmentList = r.getEquipment().split(","); %>
            <% for (String eq : equipmentList) { %>
                <input type="checkbox" name="selected_equipment" value="<%= eq.trim() %>"><%= eq.trim() %><br>
            <% } %>
            <br>
            <input type="submit" value="Book Room">
        </form>
    </div>
    <%
            }
        } else {
    %>
        <p>No rooms available at the selected time.</p>
    <%
        }
    %>
    <footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>
