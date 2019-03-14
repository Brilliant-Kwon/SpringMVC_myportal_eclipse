<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-13
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>업로드 결과창</title>
</head>
<body>
<%--urlImage  ->  img 태그에 표시--%>
<img src="${pageContext.servletContext.contextPath}/${urlImage}">
<a href="${pageContext.servletContext.contextPath}/upload/form">다시 업로드</a>

</body>
</html>
