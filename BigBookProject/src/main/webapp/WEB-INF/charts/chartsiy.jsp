<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIarg1C "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
.row {
    margin: 0px auto;
    width:1100px;
}
td,th{
   font-size: 9pt;
}
h2{
    text-align: center;
}
#container1 {
	min-width: 310px;
	max-width: 800px;
	height: 400px;
	margin: 0 auto
}
</style>
<script type="text/javascript">
$(function(){
	Highcharts.chart('container3', {

	    title: {
	        text: '2016-2018 월별 평균대출도서 권수 비교'
	    },

	    subtitle: {
	        text: 'Source: https://www.data4library.kr/openCenter'
	    },

	    yAxis: {
	        title: {
	            text: '월별 평균 대출권수'
	        }
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 1
	        }
	    },

	    series: [{
	        name: '2018',
	        data: <%= request.getAttribute("data0")%>
	    }, {
	        name: '2017',
	        data: <%= request.getAttribute("data1")%>
	    }, {
	        name: '2016',
	        data: <%= request.getAttribute("data2")%>
	    }],

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            }, 
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }

	});	
});

</script>
</head>
  <body id="page-top">
  
        <div class="container-fluid">

          <!-- 상단 제목 -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
             BigBook
            </li>
            <li class="breadcrumb-item active">Charts</li>
          </ol>
        </div>
        
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
   		
   		
	<div class="container">
		<div id="container3"></div>
	</div>
	  <div class="row">
  	<table class="table table-hover">
  		<tr class="info">
  		 <th class="text-center">no</th>
  		 <th class="text-center">YEAR</th>
  		 <th class="text-center">MONTH</th>
  		 <th class="text-center">랭킹</th>
  		 <th class="text-center">도서명</th>
  		 <th class="text-center">사진</th>
  		 <th class="text-center">지은이</th>
  		 <th class="text-center">출판사</th>
  		 <th class="text-center">대출권수</th>
  		</tr> 
  		<c:forEach var="vo" items="${bList }">
	  		<tr class="info">
	  		 <td class="text-center">${vo.no }</td>
	  		 <td class="text-center">${vo.year }</td>
	  		 <td class="text-center">${vo.month }</td>
	  		 <td class="text-center">${vo.ranking }</td>
	  		 <td class="text-center">${vo.bookname }</td>
	  		 <td class="text-center"><img src="${vo.bookImageURL }" width=150 height=150></td>
	  		 <td class="text-center">${vo.authors }</td>
	  		 <td class="text-center">${vo.publisher }</td>
	  		 <td class="text-center">${vo.loan_count }</td>
	  		 
	  		</tr> 
 		</c:forEach>
  	</table>
  </div>
</body>
</html>