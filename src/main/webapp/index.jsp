<%@ page import="tms.kolesnik.project.repository.ConnectionPool" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="tms.kolesnik.project.objects.products.Product" %>
<%@ page import="tms.kolesnik.project.objects.products.ProductBuilder" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tms.kolesnik.project.repository.users.UsersRoles" %>
<%@ page import="tms.kolesnik.project.repository.users.Person" %>
<%@ page import="tms.kolesnik.project.repository.users.AdminBuilder" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page import="java.security.spec.InvalidKeySpecException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="tms.kolesnik.project.repository.SystemService" %>
<%@page contentType="text/html" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="ru"/>


<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Kalina</title>
    <style>
        <%@include file="css/bootstrap.min.css"%>
        <%@include file="css/index.css"%>
    </style>
</head>
<body>
<nav class="navbar bg-body-tertiary">
    <div class="container text-center">
        <div id="mainRow" class="row">
            <div class="col-sm-2">
                <img src="img/kalina.jpg" alt="Logo" width="100" class="d-inline-block align-text-top">
            </div>
            <div class="col-sm-3">
                <h1 id="shopName"><fmt:message key="main.shopName"/></h1>
            </div>
            <div class="col-sm-3">
            </div>
            <div class="col-sm-2">
                <%--<button id="btnLogIn" type="button" class="btn btn-outline-info" onclick=""><fmt:message key="main.authorizationButton"/></button>--%>
                <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight"><fmt:message key="main.logIn"/></button>

                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasRightLabel"><fmt:message key="main.authorization"/></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <form action=<c:url value="/authorization"/> method="post">
                            <div>
                                <input id="email" name="email" type="email" autocomplete="off" placeholder="<fmt:message key="main.email"/>" required>
                            </div>
                            <div>
                                <input id="password" name="password" type="password" autocomplete="off" placeholder="<fmt:message key="main.password"/>" required>
                            </div>
                            <div>
                                <input id="enter" type="submit">
                            </div>
                        </form>
                        <a href="<c:url value="/registrationForm"/>">
                            <button type="button" class="btn btn-outline-dark"><fmt:message key="main.registration"/></button>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
                <button type="button" class="btnCart"></button>
            </div>
        </div>
    </div>
</nav>

<%
    ArrayList<Product> productsList = SystemService.getProductList();
    if(SystemService.thereIsNotAdminAccount()) {
        Person admin = null;
        try {
            admin = new AdminBuilder()
                    .name(request.getServletContext().getInitParameter("adminName"))
                    .password(request.getServletContext().getInitParameter("passwordHash"))
                    .email(request.getServletContext().getInitParameter("adminEmail"))
                    .phone(request.getServletContext().getInitParameter("adminPhone"))
                    .build();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            System.out.println(e.getMessage());
        }
        SystemService.createFirstAdminAccount(admin);
    }
    request.setAttribute("products", productsList);
%>
<div class="d-flex">
    <div class="container text-center">
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-md-3">
                    <div class="card" style="width: 18rem;">
                        <img src="<c:out value="${product.img}"/>" class="card-img-top" alt="Not found">
                        <div class="card-body">
                            <h2 class="card-title"><c:out value="${product.name}"/></h2>
                            <h3><fmt:message key="main.price"/>: <c:out value="${product.price}"/>p.</h3>
                            <p class="card-text"><c:out value="${product.shortDescription}"/>...</p>
                            <a href="#" class="btn btn-primary"><fmt:message key="main.information"/></a>
                            <a href="#" class="btn btn-primary"><fmt:message key="main.addInCart"/></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>