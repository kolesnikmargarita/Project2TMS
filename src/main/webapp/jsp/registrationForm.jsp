<%--
  Created by IntelliJ IDEA.
  User: mkole
  Date: 13.01.2024
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="ru"/>
<html>
<head>
    <title>KalinaRegistration</title>
</head>
<body>
<form action=<c:url value="/registrationSafe"/> method="post">
    <div>
        <input id="name" name="name" type="text" autocomplete="off" placeholder="<fmt:message key="main.name"/>" required>
    </div>
    <div>
        <input id="phone" name="phone" type="tel" autocomplete="off" placeholder="<fmt:message key="main.phone"/>" required>
    </div>
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
</body>
</html>
