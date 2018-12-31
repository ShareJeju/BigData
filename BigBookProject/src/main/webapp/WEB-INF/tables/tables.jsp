<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
 

    <title>SB Admin - Tables</title>
    <link href="../../book/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../book/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="../../book/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="../../book/css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="../../book/css/bootstrap.min.css" type="text/css">
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
select{
	width:55px;
	height:25px;
}
    </style>

  </head>

  <body id="page-top">
    <div id="wrapper">
      <div id="content-wrapper">
        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              BigBook
            </li>
            <li class="breadcrumb-item active">Tables</li>
          </ol>
         </div>
        </div>
      </div>       
      
      <!-- 게시판 부분 -->
       <div class="container">
     <div class="row">
       <h2>게시판</h2>
       <table class="table">
          <tr>
             <td>
                <a href="board/insert.do" class="btn btn-xs btn-danger">새글</a>
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
               Search : <select name=fs>
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
