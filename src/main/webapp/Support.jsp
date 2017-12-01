<%--
  Created by IntelliJ IDEA.
  User: Mayank
  Date: 01-12-2017
  Time: 04:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.jqGrid.min.js"></script>
    <script src="js/grid.locale-en.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="css/bikeRental.css"/>
    <link rel="stylesheet" href="css/ui.jqgrid.css">
    <link rel="stylesheet" href="css/jquery-ui.css">

    <script type="text/javascript" src="js/bikes.js"></script>
    <title>UL Bike Rental</title>
    <style></style>
    <title>UL Bike Rental</title>
</head>
<body>

<script type="text/javascript">
    $(document).ready(function () {
        if ("JSON" in window) console.log("Yes, json"); else console.log("no json");

        $(function(){
            $("#b1").on("click", function(){
                var a = $("form").serializeArray();
                var s = JSON.stringify(a);
                console.log("s is ", s);
            });
        });
    });
</script>
</body>
</html>
