<%--
  Created by IntelliJ IDEA.
  User: deus
  Date: 24.05.2020
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Result Page</title>
  </head>
  <body>
  <%
      String result = String.valueOf(request.getAttribute("optimalResult"));
  %>

  <h1>Result:<br><%=result%></h1>
  </body>
</html>
