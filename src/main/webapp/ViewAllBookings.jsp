<%@ page import="java.util.*, project.roomreserve.Booking" %>
<%@ page session="true" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Bookings</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <div class="title">RoomReserve</div>
</header>

<div class="main">
    <h2 class="page-heading">All Bookings</h2>
    <div class="container">
        <table>
            <tr>
                <th>Employee Name</th>
                <th>Email</th>
                <th>Room Name</th>
                <th>Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Equipment</th>
            </tr>
            <%
                if (bookings != null && !bookings.isEmpty()) {
                    for (Booking b : bookings) {
            %>
            <tr>
                <td><%= b.getEmployee_name() %></td>
                <td><%= b.getEmployee_email() %></td>
                <td><%= b.getRoom_name() %></td>
                <td><%= b.getBooking_date() %></td>
                <td><%= b.getStart_time() %></td>
                <td><%= b.getEnd_time() %></td>
                <td><%= b.getSelected_equipment() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="7">No bookings found</td></tr>
            <% } %>
        </table>
    </div>
</div>

<footer>
    <p>&copy; 2025 RoomReserve. All rights reserved.</p>
</footer>
</body>
</html>

