<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="models.Holiday" %>
<%@ page import="java.util.List" %>
<c:set var="employee" value="${employee}" />


<!DOCTYPE html>
<html>
<head>
    <title>Employee Data</title>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script>
        $(document).ready(function () {
            var maxSelection = ${jobGradeHolidays.jbgr_totalnoh} - ${mandholidays};

            $('input[name="selectedHolidays"]').on('change', function () {
                var checkedCount = $('input[name="selectedHolidays"]:checked').length;
                if (checkedCount > maxSelection) {
                    this.checked = false;
                }
            });

            $('#submitBtn').click(function () {
                var checkedCount = $('input[name="selectedHolidays"]:checked').length;
                if (checkedCount < maxSelection) {
                    alert('Please select ' + maxSelection + ' holidays.');
                    return false;
                }
            });
        });
    </script>
</head>
<body>
    <h1>Employee Information</h1>

    <h2>Employee Details</h2>
    <p>Employee ID: ${employee.emplId}</p>
    <p>Employee Job Grade: ${employee.emplJbgrId}</p>
    <p>Name: ${employee.emplFirstname} ${employee.emplLastname}</p>
    <!-- Add other employee details as needed -->

    <h2>Holiday Information</h2>
    <p>Total Number of Holidays: ${jobGradeHolidays.jbgr_totalnoh}</p>
    <p>Total Number of Optional Holidays: ${jobGradeHolidays.jbgr_totalnoh - mandholidays}</p>
    <!-- Add other leave-related information as needed -->

    <form method="post" action="/submit">
        <table id="dataTable">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Holiday Date</th>
                    <th>Holiday Title</th>
                    <th>Holiday Type</th>
                    <th>Select</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Holiday> holidays = (List<Holiday>) request.getAttribute("holidays");
                if (holidays != null) {
                    for (Holiday holiday : holidays) { %>
                        <tr>
                            <td><%= holiday.getYear() %></td>
                            <td><%= holiday.gethday_date() %></td>
                            <td><%= holiday.gethday_title() %></td>
                            <td><%= holiday.gethday_type() %></td>
                            <td class="checkbox-cell">
                                <input type="checkbox" name="selectedHolidays" value="<%= holiday.getYear() %>|<%= holiday.gethday_date() %>">
                            </td>
                        </tr>
                    <% }
                } %>
            </tbody>
        </table>

        <input type="submit" value="Submit" id="submitBtn">
    </form>
</body>
</html>
