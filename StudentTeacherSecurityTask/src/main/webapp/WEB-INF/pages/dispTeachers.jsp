<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" >Hey Congratulations You have logged in succussfully</h1><br>
<h1 style="color: darkmagenta" > Total Teachers list</h1>
<h4>Welcome ${pageContext.request.userPrincipal.name}</h4>
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
    <c:forEach items="${teacherData}" var="teach">
        <tr>
                <%-- <td><a href="display/${std.id}">${std.id}</a></td>--%>
            <td>${teach.id}</td>
            <td>${teach.name}</td>
            <td>${teach.age}</td>
            <td>${teach.address}</td>
            <td>${teach.username}</td>
                    <td>${teach.password}</td>
                    <td>${teach.role}</td>
                    <td>${teach.enabled}</td>
                  <td><a href="updateTeacher/${teach.id}">update</a></td>
                  <td><a href="deleteTeacher/${teach.id}">delete</a></td>
        </tr>
    </c:forEach>

</table><br><br>
<a href="index.jsp"><input type="button" value="home" style="color: springgreen" ></a>
<a href="studTeachReg"><input type="button" value="register" style="color: red" > </a><br>
<a href="updateTeacher/${teach.id}"><input type="button" value="update" style="color: blue"> </a>
<a href="logout"><input type="button" value="logout" style="color: springgreen" ></a>
<a href="password"><input type="button" value="change password" style="color: springgreen" ></a>