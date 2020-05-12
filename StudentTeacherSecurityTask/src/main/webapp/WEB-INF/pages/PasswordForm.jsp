
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkblue">Change Password</h1>
<c:url value="/passwordAction" var="formUrl"/>
<form:form modelAttribute="reg12" action="${formUrl}" method="post">
    <table>

        <tr>
            <td>Old Password  : </td>
            <td><form:input path="oldPassword" /></td>
        </tr>
        <tr>
            <td>New Password  :</td>
            <td><form:input path="newPassword"/></td>
        </tr>
        <tr>
            <td>Confrim New Password  :</td>
            <td><form:input path="confirmNewPassword"/></td>
        </tr>

        <tr>

            <td><input type="submit" value="change Password" style="color: darkblue"></td>

        </tr>

    </table><br>
    <a href="index.jsp"><input type="button" value="home" align="centre" style="color: red"></a>


</form:form>
