<%@ page import="java.util.*, project.roomreserve.Booking" %>
<%@ page session="true" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>

<html>
<head>
    <title>Booked Rooms</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<div class="title">RoomReserve</div>
    
</header>
    <h2>Your Booked Rooms</h2>
    <table>
        <tr>
            <th>Room Name</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Equipment</th>
            <th>Action</th>
        </tr>
        <%
            if (bookings != null) {
                for (Booking b : bookings) {
        %>
        <tr>
    <td><%= b.getRoom_name() %></td>
    <td><%= b.getBooking_date() %></td>
    <td><%= b.getStart_time() %></td>
    <td><%= b.getEnd_time() %></td>
    <td><%= b.getSelected_equipment() %></td>
    <td>
        <form action="CancelBooking" method="post">
            <input type="hidden" name="booking_id" value="<%= b.getBooking_id() %>" />
            <button type="submit">Cancel</button>
        </form>
    </td>
</tr>

        <%
                }
            } else {
        %>
        <tr><td colspan="6">No bookings found</td></tr>
        <% } %>
    </table>
    <footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>
