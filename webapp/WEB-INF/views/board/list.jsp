<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--jstl 사용하기 위해 라이브러리 추가--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Homepage</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="<%= request.getContextPath() %>/css/board.css" rel="stylesheet" type="text/css"/>
    <link type="text/css"
          rel="stylesheet"
          href="<%= request.getContextPath() %>/css/users.css"/>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath }/javascript/jquery/jquery-1.9.0.js"></script>
    <script type="text/javascript">
        function checkDelete(obj) {
//삭제할 것인지 확인
            //confirm
            var result = confirm("정말로 삭제하시겠습니까?");
            if (result) {
                //확인
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div id="container">

    <%--HEADER영역--%>
    <jsp:include page="../includes/header.jsp"/>
    <%--NAVIGATION영역--%>
    <jsp:include page="../includes/navigation.jsp"/>

    <div id="content">
        <div id="board">
            <!--form id="search_form" action="" method="post">
                <input type="text" id="kwd" name="kwd" value="">
                <input type="submit" value="찾기">
            </form -->
            <table class="tbl-ex">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>&nbsp;</th>
                </tr>

                <c:set var="authUser" scope="session" value="${sessionScope.authUser}"/>
                <c:forEach items="${list}" var="vo">

                    <tr>
                        <td>${vo.no}</td>
                        <td><a href="${pageContext.servletContext.contextPath }/board/view/${vo.no}">${vo.title}</a></td>
                        <td>${vo.user_name}</td>
                        <td>${vo.hit}</td>
                        <td>${vo.reg_date}</td>

                            <%--<%--%>
                            <%--System.out.println("authUser no"${authUser}.no);--%>
                            <%--%>--%>
                        <td>
                            <c:if test="${not empty authUser}">
                                <c:if test="${authUser.no == vo.user_no}">
                                    <a href="${pageContext.servletContext.contextPath }/board/delete/${vo.no}" onclick="checkDelete(this)">삭제</a>
                                    <%--href="${pageContext.servletContext.contextPath }/board/delete" class="del"--%>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>

                </c:forEach>
            </table>

            <!--div class="pager">
          <ul>
             <li><a href="">◀</a></li>
             <li><a href="">1</a></li>
             <li><a href="">2</a></li>
             <li class="selected">3</li>
             <li><a href="">4</a></li>
             <li>5</li>
             <li><a href="">▶</a></li>
          </ul>
       </div -->

            <div class="bottom">
                <a href="${pageContext.servletContext.contextPath }/board/write" id="new-book">글쓰기</a>
            </div>
        </div>
    </div>

    <jsp:include page="../includes/footer.jsp"/>

</div>
</body>
</html>
