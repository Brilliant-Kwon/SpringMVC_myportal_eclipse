<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Homepage</title>
    <!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
    <link type="text/css"
          rel="stylesheet"
          href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
<div id="container">
    <%--HEADER영역--%>
    <jsp:include page="../includes/header.jsp"/>
    <%--NAVIGATION영역--%>
    <jsp:include page="../includes/navigation.jsp"/>
    <div id="wrapper">
        <div id="content">
            <!-- Content 영역 -->
            <div id="user">
                <form id="join-form" name="joinform" method="post" action="<%=request.getContextPath()%>/users/join">
                    <%--입력폼--%>
                    <label class="block-label" for="name">이름</label>
                    <input type="text" name="name" id="name">

                    <label class="block-label" for="password">비밀번호</label>
                    <input type="password" name="password">

                    <label class="block-label" for="email">이메일</label>
                    <input type="text" name="email" id="email">

                    <fieldset>
                        <legend>성별</legend>
                        <input type="radio" name="gender" value="F">여성
                        <input type="radio" name="gender" value="M">남성
                    </fieldset>

                    <input type="submit" value="가입하기">
                </form>
            </div>

        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
    <%--<%@include file="../includes/footer.jsp"%>--%>
</div>
</body>
</html>