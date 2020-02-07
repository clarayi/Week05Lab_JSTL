<%-- 
    Document   : shoppinglist
    Created on : Feb 6, 2020, 9:00:46 PM
    Author     : 810783
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello,${username} <a href="">Logout</a><br>
        <form method="post">
            <h2>List</h2>
            Add item: <input name="inputItem" type="text" required/> <input type="submit" value="Add" formaction="ShoppingList?action=add">
        </form>
        <table>
            <c:forEach var="oneItem" items="${itemList}">
                <tr>
                    <td><input type="radio" value="${oneItem}"/></td>
                    <td>${oneItem}</td>
                </tr>
            </c:forEach>
            <c:if test="${itemList.size > 1}">
                <tr>
                    <td colspan="2"><input type="submit" value="Delete" formaction="ShoppingList?action=delete"</td>
                </tr>
            </c:if>
        </table>
    </body>
</html>
