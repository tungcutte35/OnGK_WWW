<%@ page import="com.example.demo.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TungMTP
  Date: 10/26/2023
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<h1>Report 2 Page</h1>
<% List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates"); %>
<table>
    <thead>
    <tr>
        <th>fullName</th>
        <th>email</th>
        <th>phone</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Candidate candidate : candidates) {
            if (candidate.getEmail() != null) {%>
    <tr>
        <td><%= candidate.getFull_name()%>
        </td>
        <td><%= candidate.getEmail()%>
        </td>
        <td><%= candidate.getPhone()%>
        </td>
        <td><a href="controller?action=candidateDetails&id=<%= candidate.getId()%>">View</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
