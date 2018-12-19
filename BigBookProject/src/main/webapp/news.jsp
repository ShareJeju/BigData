<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
	<c:forEach var="vo" items="${nlist }" varStatus="s">
		<c:if test="${s.index<5 }">
		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<td rowspan="3" width=30%>
						<a href="${vo.link }"><img src="${vo.poster }" width=300 height=300></a>
						</td>
						<th class="success text-center"><a href="${vo.link }">${vo.title }</a></th>
					</tr>
					<tr>
						<td width=70% class="text-center">${vo.auth } ${vo.pubDate }</td>
					</tr>
					<tr>
						<td width=70%>${vo.description }</td>
					</tr>
				</table>
			</td>
		</tr>
		</c:if>
	</c:forEach>
	</table>
</body>
</html>