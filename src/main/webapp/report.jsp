<%@ page import="com.example.demo.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.enums.Roles" %><%--
  Created by IntelliJ IDEA.
  User: TungMTP
  Date: 10/26/2023
  Time: 17:28
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
<h1>Report Page</h1>
<%
    Roles[] roles = Roles.values();
%>
<form action="controller" method="GET">
    <input type="hidden" name="action" value="findCandidateByRole">
    <select name="role">
        <% for (Roles role : roles) {%>
        <option value=<%= role.ordinal()%>><%= role.name()%>
        </option>
        <%}%>
    </select>
    <button type="submit">View</button>
</form>
<%
    List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
    if (candidates != null) {
%>
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
    <% for (Candidate candidate : candidates) { %>
    <tr>
        <td><%= candidate.getFull_name()%>
        </td>
        <td><%= candidate.getEmail()%>
        </td>
        <td><%= candidate.getPhone()%>
        </td>
        <td><a href="controller?action=candidateDetails&id=<%= candidate.getId()%>">View</a></td>
    </tr>
    <% }%>
    </tbody>
</table>
<%
    }
%>
</body>
</html>