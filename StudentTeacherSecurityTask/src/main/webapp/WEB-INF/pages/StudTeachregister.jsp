<%--
  Created by IntelliJ IDEA.
  User: Interview
  Date: 3/3/2020
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkblue">Register As Student As Well As Teacher Here</h1>
<c:url value="/saveStudTeachData" var="formUrl"/>
<form:form modelAttribute="reg" action="${formUrl}" method="post">
    <table>
        <tr>
            <td>ID  : </td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>NAME  :</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>AGE  :</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>ADDRESS  :</td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td>USERNAME  :</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>PASSWORD  :</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>ROLE_NAME :</td>
            <td><form:select path="role">
                <form:options items="${rolesList}"/>
            </form:select></td>
        </tr>
        <tr>
            <td>ENABLED  :</td>
            <td><form:input path="enabled"/></td>
        </tr>
        <tr>

            <td><input type="submit" value="Register" style="color: darkblue"></td>

        </tr>

    </table><br>
    <a href="index.jsp"><input type="button" value="home" align="centre" style="color: red"></a>
    <a href="index.jsp"><input type="button" value=" back " style="color: blue" ></a>

</form:form>
