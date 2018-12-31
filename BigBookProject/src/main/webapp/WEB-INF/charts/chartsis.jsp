<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Custom styles for this template-->


<link href="css/sb-admin.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
 <script type="text/javascript">
  $(function(){

	  Highcharts.chart('container2', {
	    chart: {
	      type: 'column'
	    },
	    title: {
	      text: '3년간 주제별 도서관 도서 대출 현황'
	    },
	    subtitle: {
	      text: '출처: https://www.data4library.kr'
	    },
	    xAxis: {
	      categories: [
	       
	        '철학',
	        '종교',
	        '사회과학',
	        '자연과학',
	        '기술과학',
	        '예술',
	        '언어',
	        '문학',
	        '역사'
	      ],
	      crosshair: true
	    },
	    yAxis: {
	      min: 0,
	      title: {
	        text: '도서 대출(권)'
	      }
	    },
	    tooltip: {
	      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	        '<td style="padding:0"><b>{point.y:.1f} 권</b></td></tr>',
	      footerFormat: '</table>',
	      shared: true,
	      useHTML: true
	    },
	    plotOptions: {
	      column: {
	        pointPadding: 0.2,
	        borderWidth: 0
	      }
	    },
	    series: [{
	      name: '2016',
	      data: <%= request.getAttribute("data0")%>
	   /*  [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1] */
	    

	    }, {
	      name: '2017',
	      data: <%= request.getAttribute("data1")%>
	    /*   [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5] */
	    }, {
	      name: '2018',
	      data: <%= request.getAttribute("data2")%>
	   /*   data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2] */
	   
	    }]
	  })
	  });
  </script>
</head>
<body>
  <!-- 상단 제목-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">BigBook
            </li>
            <li class="breadcrumb-item active">Charts</li>
          </ol>
          
          <!-- Nav Bar -->
   		<table class="table">
   			<tr>
   				<td align="center">
   					<a href="../../book/charts/chartsiy.do" class="btn btn-xs btn-default">2016-2018 월별 평균대출도서 권수 비교</a>
   					<a href="../../book/location/map.do" class="btn btn-xs btn-default">서울 지역 도서대출 현황</a>
   					<a href="../../book/charts/chartsjh.do" class="btn btn-xs btn-default">2018년 연령별 인기도서 200권 대출 현황</a>
   					<a href="../../book/charts/chartsyj.do" class="btn btn-xs btn-default">지역별 대출 장르 현황</a>
   					<a href="../../book/charts/chartsis.do" class="btn btn-xs btn-default">3년간 주제별 도서관 도서 대출 현황</a>
   				</td>
   			</tr>
   		</table>
<div id="container2" style="min-width: 310px; height: 400px; margin: 0 auto">

</div>

  <div class="row">
  <h3>주제별 대출 1위 도서 목록</h3>
    <table class="table table-hover">
      <tr class="info">
      
        <th width=20% class="text-center">책 제목</th>
        <th width=15% class="text-center">작가</th>
        <th width=15% class="text-center">대출권수</th>
        <th width=20% class="text-center">사진</th>
        <th  width=15% class="text-center">주제</th>
        <th width=15% class="text-center">년도</th>
      </tr>
      <c:forEach var="vo" items="${blist }">
	      <tr>
	        <td class="text-center">${vo.bookname }</td>
	         <td class="text-center">${vo.authors }</td>
	         <td class="text-center">${vo.loan_count }</td>
	        <td class="text-center"><img src="${vo.bookImageURL }" width=200px></td>
	        <td class="text-center">${vo.subject }</td>
	        <td class="text-center">${vo.year }</td>
	      </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>