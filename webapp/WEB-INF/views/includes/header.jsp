
<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-04
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<div id="header">
    <h1>My Homepage</h1>
    <ul>
        <%--로그인 된 경우의 메뉴--%>
        <%-- <li><a href="<%=request.getContextPath() %>/users?a=logout">로그아웃</a></li>
        <li><%=authUser.getName()%>님 안녕하세요.</li> --%>
        <%--로그인 안 된 경우의 메뉴--%>
        <li><a href="<%=request.getContextPath() %>/users?a=loginform">로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/users?a=joinform">회원가입</a></li>
   
    </ul>
</div>
<!-- /header -->