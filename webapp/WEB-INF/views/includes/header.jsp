<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-04
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <h1>My Homepage</h1>
    <ul>
        <%--로그인 된 경우의 메뉴--%>
        <%--
        <li><a href="<%=request.getContextPath() %>/users?a=logout">로그아웃</a></li>
        <li>님 안녕하세요.</li>
        --%>
        <c:set var="authUser" scope="session" value="${sessionScope.authUser}"/>
        <c:choose>
            <c:when test="${authUser ne null}">
                <%--<c:otherwise>--%>
                <li><a href="<%=request.getContextPath() %>/users/logout">로그아웃</a></li>
                <li>${authUser.name}님 안녕하세요.</li>
                <%--</c:otherwise>--%>
            </c:when>

            <c:when test="${empty authUser}">
                <%--로그인 안 된 경우의 메뉴--%>
                <li><a href="<%=request.getContextPath() %>/users/login">로그인</a></li>
                <li><a href="<%=request.getContextPath() %>/users/join">회원가입</a></li>
            </c:when>
        </c:choose>
    </ul>
</div>
<!-- /header -->