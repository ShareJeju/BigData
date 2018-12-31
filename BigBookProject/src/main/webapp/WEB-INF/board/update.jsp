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
       <h2>수정하기</h2>
       <form method=post action="update_ok.do">
       <table class="table">
          <tr>
              <th class="danger text-right" width=20%>이름</th>
              <td class="text-left" width=80%>
                 <input type=text name=name size=15 value="${vo.name }">
                 <input type="hidden" name=no value="${vo.no }">
              </td>
          </tr>
          <tr>
              <th class="danger text-right" width=20%>제목</th>
              <td class="text-left" width=80%>
                 <input type=text name=subject size=45 value="${vo.subject }">
              </td>
          </tr>
          <tr>
              <th class="danger text-right" width=20%>내용</th>
              <td class="text-left" width=80%>
                 <textarea rows="10" cols="50" name=content>${vo.content }</textarea>
              </td>
          </tr>
          <tr>
              <th class="danger text-right" width=20%>비밀번호</th>
              <td class="text-left" width=80%>
                 <input type="password" name=pwd size=10>
              </td>
          </tr>
          <tr>
             <td class="text-center" colspan="2">
                 <input type="submit" value="수정">
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
