<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-13
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일 업로드</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath }/upload/upload" enctype="multipart/form-data">
    <label>File</label>
    <input type="file" name="user_file">
    <input type="submit" name="업로드">

</form>
</body>
</html>
