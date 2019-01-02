<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%-- <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!--  <script type="text/javascript">
$(function(){
	init();
	});

function init()
{
	$.ajax({
		type:'post',
		url:'main_news.do',
		success:function(response){
			$('#news').html(response);
		}
	});	
}
</script>  -->
<style type="text/css">

.float {
float:left;
}

</style>
</head>
<body>
 

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Overview</li>
          </ol>

          <!-- Icon Cards-->
          
          
          <div class="row">
          
            <div class="col-xl-8">
             
            <h2>오늘의 도서 뉴스</h2>
          

				<form class="col-xl-12" action="../../book/main.do">

					<label class="control-label col-xl-2" for="fd">Search:</label>
					<div class="col-xl-8" >
						<input  type="text" class="form-control " name="title"
							placeholder="뉴스 검색">
							<%--  <%= application.getRealPath("/") %> --%>
					</div>
					<div class="col-xl-4 ">
						<input type="submit" class="form-control btn btn-sm btn-danger "
							value="검색">
					</div>

				</form>

				<table class="table"> 
	<c:forEach var="vo" items="${nlist }" varStatus="s">

		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<td rowspan="3" width=30%>
						<a href="${vo.link }"><img src="${vo.poster }" width=300 height=200></a>
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

	</c:forEach>
	</table>
<table style="text-align:center">
<tr>
<td>
  <a href="../../book/main.do?title=${title }&page=${curpage>1?curpage-1:curpage}"><button type="button" class="btn btn-default">이전</button></a>
 <a href="../../book/main.do?title=${title }&page=${curpage<5?curpage+1:curpage}" ><button type="button" class="btn btn-default">다음</button></a>
</td>
</tr>
</table>
</div>

 <div class="col-xl-4">
<img src="wordcloud.png">
</div> 
          

          </div>


</body>
</html>