<%-- 
    Document   : register
    Created on : Feb 6, 2020, 9:00:31 PM
    Author     : 810783
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CPRG352 Lab5 JSTL</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList?action=register">
        <!--Alternative: <input type="hidden" name="action" value="register"/>-->
            Username: <input type="text" name="username" required/> 
            <input type="submit" value="Register name"/>
        </form>
    </body>
</html>
