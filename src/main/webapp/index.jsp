<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Index page</title>
</head>
<style> .ul {
    text-decoration: none;
    color: black;
    font-size: 20px;
    font-weight: bold;
    padding: 10px;
    border-radius: 20px;
    background-color: #f2f2f2;
    margin: 10px;
    display: inline-block;
    text-align: center;
    width: 200px;
    height: 50px;
    line-height: 50px;

}
.ht {
  text-align: center;

}
</style>
<body>

<div class="ht">
  <h1><%= "Index page" %></h1>
  <br/>
  <a class="ul" href="controller?action=candidate">candidate</a><br>
  <a  class="ul" href="controller?action=report">report1</a><br>
  <a class="ul" href="controller?action=report2">report2</a><br>
</div>
</body>
</html>