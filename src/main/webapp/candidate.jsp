<%@ page import="com.example.demo.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TungMTP
  Date: 10/26/2023
  Time: 17:25
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
<% List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates"); %>
<h1>Candidate Page</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>fullName</th>
        <th>email</th>
        <th>phone</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <% for (Candidate candidate : candidates) { %>
    <tr>
        <td><%= candidate.getId()%></td>
        <td><%= candidate.getFull_name()%></td>
        <td><%= candidate.getEmail()%></td>
        <td><%= candidate.getPhone()%></td>
        <td><a href="controller?action=candidateDetails&id=<%= candidate.getId()%>">View</a></td>
    </tr>
    <% }%>
    </tbody>
</table>
</body>
</html>
