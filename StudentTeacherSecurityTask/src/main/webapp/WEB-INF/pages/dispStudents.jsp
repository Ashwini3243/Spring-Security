<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" >Hey Congratulations You have logged in succussfully</h1><br>
<h3 style="color: darkmagenta" > Total Students list</h3>
<h4>Welcome ${pageContext.request.userPrincipal.name}</h4>
<h4>hai ${username}</h4>
<table border="2" cellspacing="0" cellpadding="8" style="border-color: darkblue" >
    <tr >
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>address</th>
        <th>username</th>
        <th>password</th>
        <th>role</th>
        <th>enabled</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${studentData}" var="std">
        <tr>
                <%-- <td><a href="display/${std.id}">${std.id}</a></td>--%>
            <td>${std.id}</td>
            <td>${std.name}</td>
            <td>${std.age}</td>
            <td>${std.address}</td>
            <td>${std.username}</td>
           <td>${std.password}</td>
                    <td>${std.role}</td>
                    <td>${std.enabled}</td>
            <td><a href="updateStudent/${std.id}">update</a></td>
            <td><a href="deleteStudent/${std.id}">delete</a></td>
        </tr>
    </c:forEach>

</table><br><br>
<a href="index.jsp"><input type="button" value="home" style="color: springgreen" ></a>
<a href="studTeachReg"><input type="button" value="register" style="color: red" > </a><br>
<a href="updateStudent/${std.stu_Id}"><input type="button" value="update" style="color: blue"> </a>
<a href="logout"><input type="button" value="logout" style="color: springgreen" ></a>
<a href="password"><input type="button" value="change password" style="color: springgreen" ></a>