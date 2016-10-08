<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" >
    <title>@ControllerAdvice demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="request" />

<script src="assets/js/jquery.min.js" type="text/javascript"></script>

<script>
    function req(){

        $.ajax({
            url:"convert",
            data:"22-martix",
            type:"POST",
            contentType:"application/x-wisely",
            success:function(data){
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>