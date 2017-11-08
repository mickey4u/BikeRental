<%--
  Created by IntelliJ IDEA.
  User: Molly
  Date: 11/8/2017
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
< %
HttpSession session = request.getSession(true);
if (session.getAttribute("loggedIn")==null)
{
% >
<jsp:forward page="/Login.jsp?msg=You will have to login first in order to access other pages"></jsp:forward>
< %
}
% >
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>Dashboard</h5>
</body>
</html>
