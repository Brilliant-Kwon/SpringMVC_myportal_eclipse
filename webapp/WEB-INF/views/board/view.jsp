<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My Homepage</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="<%= request.getContextPath() %>/css/board.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div id="container">
    <%--HEADER영역--%>
    <jsp:include page="../includes/header.jsp"/>
    <%--NAVIGATION영역--%>
    <jsp:include page="../includes/navigation.jsp"/>

    <c:set var="authUser" scope="session" value="${sessionScope.authUser}"/>

    <c:set var="vo" value="${vo}"/>

    <div id="content">
        <div id="board" class="board-form">
            <table class="tbl-ex">
                <tr>
                    <th colspan="2">글보기</th>
                </tr>
                <tr>
                    <td class="label">제목</td>
                    <td>${vo.title}</td>
                </tr>
                <tr>
                    <td class="label">내용</td>
                    <td>
                        <div class="view-content">
                            ${vo.content}
                        </div>
                    </td>
                </tr>
            </table>
            <div class="bottom">
                <a href="${pageContext.servletContext.contextPath }/board/list">글목록</a>
                <c:if test="${not empty authUser}">
                    <c:if test="${authUser.no == vo.user_no}">
                        <a href="${pageContext.servletContext.contextPath }/board/modify/${vo.no}">글수정</a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
</html>
