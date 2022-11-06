<%-- 
    Document   : admin
    Created on : Nov 5, 2022, 3:07:25 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1> Welcome:  ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}">Logout</a>
        <form action="MainController">
            Search <input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope.LIST_USER}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Full Name</th>
                            <th>Role</th>
                            <th>Phone</th>
                            <th>Mail</th>
                            <th>Password</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                        <form action="MainController">                        
                            <tr>
                                <td>${counter.count}</td>
                                <td><input type="text" name="ID" value="${user.ID}" readonly=""/></td>
                                <td><input type="text" name="username" value="${username}" required=""/></td>
                                <td><input type="text" name="fullName" value="${fullName}" required=""/></td>
                                <td><input type="text" name="mail" value="${mail}" required=""/></td>                               
                                <td><input type="text" name="role" value="${user.role}" required=""/></td>
                                <td><input type="text" name="phone" value="${phone}" required=""/></td>
                                <td>${user.password}</td>                               
                                <td>
                                    <input type="submit" name="action" value="Update"/>
                                    <input type="hidden" name="search" value="${param.search}"
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
            <c:if test="${requestScope.ERROR_MESSAGE != null}">
                ${requestScope.ERROR_MESSAGE}
            </c:if>
    </body>
</html>
