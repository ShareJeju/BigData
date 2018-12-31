<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script type="text/javascript">
$(function(){

	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '지역별 대출 장르 현황'
	    },
	    subtitle: {
	        text: '전체통계'
	    },
	    xAxis: {
	        categories: [
	            '서울',
	            '대전',
	            '대구',
	            '부산',
	            '광주'
	        ],
	        crosshair: true
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Rainfall (mm)'
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
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
	        name: '종교',
	        data: <%= request.getAttribute("data0")%>

	    }, {
	        name: '역사',
	        data: <%= request.getAttribute("data1")%>

	    }, {
	        name: '언어',
	        data: <%= request.getAttribute("data2")%>

	    }, {
	        name: '문학',
	        data: <%= request.getAttribute("data3")%>

	    }, {
	        name: '예술',
	        data: <%= request.getAttribute("data4")%>

	    }, {
	        name: '기술과학',
	        data: <%= request.getAttribute("data5")%>

	    }]
	});
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
  <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">
  </div>
  <div class="row">
    <table class="table table-hover">
      <tr class="info">
        <th class="text-center">no</th>
        <th class="text-center">제목</th>
        <th class="text-center">bookImageURL</th>
        <th class="text-center">작가</th>
        <th class="text-center">location</th>
        <th class="text-center">장르</th>
      </tr>
      <c:forEach var="vo" items="${cList }">
        <tr>
          <td class="text-center">${vo.no }</td>
          <td class="text-center">${vo.bookname }</td>
          <td class="text-center"><img id="bookposter" src="${vo.bookImageURL }" width=30 height=30></td>
          <td class="text-center">${vo.authors }</td>
          <td class="text-center">${vo.location }</td>
          <td class="text-center">${vo.genre }</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>