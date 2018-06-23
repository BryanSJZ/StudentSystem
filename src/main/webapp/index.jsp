<%@ page language="java" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>


<form action="/back/student/listStudentByConditions" method="get">
    <input type="text" name="stuName" placeholder="stuName"><br>
    <input type="text" name="stuNum" placeholder="stuNum"><br>
    <input type="text" name="classId" placeholder="classId"><br>
    <input type="submit" value="Go">
</form>


</body>
</html>
