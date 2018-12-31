<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<style type="text/css">
.row {
    margin: 0px auto;
    width:350px;
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
       <h2>삭제하기</h2>
       <form method=post action="delete_ok.do">
       <table class="table">
         <tr>
            <td class="text-left">
            비말번호:<input type="password" name=pwd size=12>
            <input type="hidden" name=no value="${no }">
            </td>
         </tr>
         <tr>
            <td class="text-center">
               <input type="submit" value="삭제">
               <input type="button" value="취소"
                     onclick="javascript:history.back()"
                    >
            </td>
         </tr>
       </table>
       </form>
     </div>
   </div>
</body>
</html>






