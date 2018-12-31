<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<style type="text/css">
.row {
    margin: 0px auto;
    width:700px;
}
td,th{
   font-size: 9pt;
}
h2{
    text-align: center;
}
</style>
</head>
<body>
   <%-- <%= application.getRealPath("/main") %> --%>
   <div class="container">
     <div class="row">
       <h2>게시판</h2>
       <table class="table">
          <tr>
             <td>
                <a href="insert.do" class="btn btn-xs btn-danger">새글</a>
             </td>
          </tr>
       </table>
       <table class="table table-hover">
           <tr class="primary">
              <th class="text-center" width=10%>번호</th>
              <th class="text-center" width=45%>제목</th>
              <th class="text-center" width=15%>이름</th>
              <th class="text-center" width=20%>작성일</th>
              <th class="text-center" width=10%>조회수</th>
           </tr>
           <c:forEach var="vo" items="${list }">
	           <tr>
	              <td class="text-center" width=10%>${vo.no }</td>
	              <td class="text-left" width=45%>
	                <a href="detail.do?no=${vo.no }">${vo.subject }</a>
	              </td>
	              <td class="text-center" width=15%>${vo.name }</td>
	              <td class="text-center" width=20%>${vo.regdate }</td>
	              <td class="text-center" width=10%>${vo.hit }</td>
	           </tr>
           </c:forEach>
       </table>
       <table class="table">
          <tr>
             <td class="text-left">
               Search:<select name=fs>
                   <option value="name">이름</option>
                   <option value="subject">제목</option>
                   <option value="content">내용</option>
               </select>
               <input type=text name=ss size=10>
               <input type=submit value="찾기" class="btn btn-xs btn-danger">
             </td>
             <td class="text-right">
                 <a href="#" class="btn btn-xs btn-primary">이전</a>
                       ${curpage } page / ${totalpage } pages
                 <a href="#" class="btn btn-xs btn-primary">다음</a>
             </td>
          </tr>
       </table>
     </div>
   </div>
</body>
</html>








