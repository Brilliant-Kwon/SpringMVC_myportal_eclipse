<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Homepage</title>
    <!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
    <link type="text/css"
          rel="stylesheet"
          href="<%= request.getContextPath() %>/css/users.css"/>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath }/javascript/jquery/jquery-1.9.0.js"></script>
    <script type="text/javascript">
        function checkEmail(btn) {
            //   이메일 필드 체크
            if (btn.form.email.value.trim().length == 0) { // 만약 btn이 소속된 form에서 email이란 이름을 가진 객체의 value 값이 공백을 제거하고 난 뒤 길이가
                alert("이메일을 입력해주세요.") // 0과 같다면 입력이 되지 않은 상태이므로 alert를 띄운다
                return;
            }
            //   JQuery Ajax 수행
            $.ajax({
                url: "${pageContext.servletContext.contextPath }/users/emailcheck", // 사용할 컨트롤러 매핑 url
                type: "get", // 메소드 수행 방식
                dataType: "json", // 넘겨받을 데이터 타입
                data: {
                    email: btn.form.email.value
                },
                success: function (response) { // 응답값: response HashMap 형태로 넘긴 그것
                    if (response.data == "exist") {
                        alert("이미 가입된 메일입니다.");
                    } else {
                        alert("사용할 수 있는 메일입니다.");
                    }
                },
                error: function (xhr, status, err) { // ajax 요청 객체 : xhr, 상태값: status, 에러값: err
                    alert(status);
                    alert(err);
                }
            });
        }
    </script>

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
                <%--<form id="join-form" name="joinform" method="post" action="<%=request.getContextPath()%>/users/join">--%>
                <form:form modelAttribute="userVo" id="join-form" name="joinForm" method="post"
                           action="${pageContext.servletContext.contextPath}/users/join">
                    <%--입력폼--%>
                    <label class="block-label" for="name">이름</label>
                    <%--<input type="text" name="name" id="name">--%>
                    <form:input path="name"/>
                    <br>
                    <spring:hasBindErrors name="userVo">

                        <c:if test="${errors.hasFieldErrors('name')}" var="e">
                            <strong>${errors.getFieldErrors('name')[0].defaultMessage}</strong>
                        </c:if>
                    </spring:hasBindErrors>

                    <label class="block-label" for="password">비밀번호</label>
                    <input type="password" name="password">

                    <label class="block-label" for="email">이메일</label>
                    <%--<input type="text" name="email" id="email">--%>
                    <form:input path="email"/>
                    <input type="button" value="중복 체크" onclick="checkEmail(this)">
                    <spring:hasBindErrors name="userVo">
                        <c:if test="${errors.hasFieldErrors('email') }">
                            <strong style="color: red"> <spring:message
                                    code="${errors.getFieldError( 'email' ).codes[0] }"
                                    text="${errors.getFieldError( 'email' ).defaultMessage }"/>
                            </strong>
                        </c:if>
                    </spring:hasBindErrors>


                    <fieldset>
                        <legend>성별</legend>
                        <input type="radio" name="gender" value="F">여성
                        <input type="radio" name="gender" value="M">남성
                    </fieldset>

                    <input type="submit" value="가입하기">
                </form:form>
                <%--</form>--%>
            </div>

        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
    <%--<%@include file="../includes/footer.jsp"%>--%>
</div>
</body>
</html>