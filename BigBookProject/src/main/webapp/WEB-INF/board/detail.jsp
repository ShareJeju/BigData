<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     1. front 
         react , vue
     2. back
         spring-boot(XML(X),Annotation)
          블록체인
         AI(딥러닝,머신러닝)
           파이썬    
 --%>
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
   <div class="container">
     <div class="row">
       <h2>내용보기</h2>
       <table class="table">
         <tr>
            <th width=20% class="text-center danger">번호</th>
            <td width=30% class="text-center">${vo.no }</td>
            <th width=20% class="text-center danger">작성일</th>
            <td width=30% class="text-center">${vo.regdate }</td>
         </tr>
         <tr>
            <th width=20% class="text-center danger">이름</th>
            <td width=30% class="text-center">${vo.name }</td>
            <th width=20% class="text-center danger">조회수</th>
            <td width=30% class="text-center">${vo.hit }</td>
         </tr>
         <tr>
            <th width=20% class="text-center danger">제목</th>
            <td colspan="3" class="text-left">${vo.subject }</td>
         </tr>
         <tr>
             <td colspan="4" class="text-left" valign="top"
                height=150>${vo.content }</td>
         </tr>
         <tr>
             <td colspan="4" class="text-right">
                <a href="update.do?no=${vo.no }" class="btn btn-xs btn-success">수정</a>
                <a href="delete.do?no=${vo.no }" class="btn btn-xs btn-info">삭제</a>
                <a href="list.do" class="btn btn-xs btn-primary">목록</a>
             </td>
         </tr>
       </table>
      <!--  <img src="board.png"> -->
     </div>
   </div>
</body>
</html>









