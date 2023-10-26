<%@ page import="com.example.demo.models.Experience" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: TungMTP
  Date: 10/26/2023
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<body>
<h1>Candidate Details Page</h1>
<p><% Candidate candidate = (Candidate) request.getAttribute("candidate");%></p>
<p><%= candidate.getId()%></p>
<p><%= candidate.getFull_name()%></p>
<p><%= candidate.getEmail()%></p>
<p><%= candidate.getPhone()%></p>

<table>
    <thead>
    <tr>
        <th>Company Name</th>
        <th>Work Description</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Roles</th>
    </tr>
    </thead>
    <tbody>
    <% List<Experience> experiences = candidate.getExperiences();
        for (Experience experience : experiences) {%>
    <tr>
        <td><%= experience.getCompany()%>
        </td>
        <td><%= experience.getWork_desc()%>
        </td>
        <td><%= experience.getFrom_date()%>
        </td>
        <td><%= experience.getTo_date()%>
        </td>
        <td><%= experience.getRole()%>
        </td>
    </tr>
    <%} %>
    </tbody>

</table>
</body>
</html>