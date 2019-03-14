<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="<%= request.getContextPath() %>/css/board.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="container">

		<%--HEADER영역--%>
		<jsp:include page="../includes/header.jsp"/>
		<%--NAVIGATION영역--%>
		<jsp:include page="../includes/navigation.jsp"/>

		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="${pageContext.servletContext.contextPath }/board/write">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="contentarea" name="content"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board/list">취소</a>
						<input type="hidden" >
						<input type="submit" value="등록">
					</div>
				</form>
			</div>
		</div>

		<jsp:include page="../includes/footer.jsp"/>
	</div>
</body>
</html>
