<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" >
    <title>@ControllerAdvice demo</title>
</head>
<body>
<div class="upload">
    <form action="upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file" /><br/>
        <input type="submit" value="upload" />
    </form>

</div>



</body>
</html>