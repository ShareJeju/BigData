<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/food.css">
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<!-- <script src="https://code.highcharts.com/modules/exporting.js"></script> -->
<style type="text/css">
#container1 {
	min-width: 310px;
	max-width: 800px;
	height: 400px;
	margin: 0 auto
}
#container2 {
	width: 100%;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
$(function(){
	
	var chart = Highcharts.chart('container2', {

	    title: {
	        text: '서울 지역 도서대출 현황'
	    },

	    subtitle: {
	        text: '전체 통계'
	    },

	    xAxis: {
	        categories: <%= request.getAttribute("category") %>
	    },

	    series: [{
	        type: 'column',
	        colorByPoint: true,
	        data: <%= request.getAttribute("total") %>,
	        showInLegend: false
	    }]

	});


	$('#plain').click(function () {
	    chart.update({
	        chart: {
	            inverted: false,
	            polar: false
	        },
	        subtitle: {
	            text: 'Plain'
	        }
	    });
	});

	$('#inverted').click(function () {
	    chart.update({
	        chart: {
	            inverted: true,
	            polar: false
	        },
	        subtitle: {
	            text: 'Inverted'
	        }
	    });
	});

	$('#polar').click(function () {
	    chart.update({
	        chart: {
	            inverted: false,
	            polar: true
	        },
	        subtitle: {
	            text: 'Polar'
	        }
	    });
	});

	Highcharts.chart('container1', {

	    title: {
	        text: '지역별 도서관 대출현황, 2010-2018'
	    },

	    subtitle: {
	        text: 'Source: data4library.kr'
	    },

	    yAxis: {
	        title: {
	            text: '대출 횟수'
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
	            pointStart: 2010
	        }
	    },

	    series: [{
	        name: '영우아',
	        data: <%= request.getAttribute("data0") %>
	    }, {
	        name: '유아',
	        data: <%= request.getAttribute("data1") %>
	    }, {
	        name: '초등학생',
	        data: <%= request.getAttribute("data2") %>
	    }, {
	        name: '20대',
	        data: <%= request.getAttribute("data3") %>
	    }, {
	        name: '30대',
	        data: <%= request.getAttribute("data4") %>
	    }, {
	        name: '40대',
	        data: <%= request.getAttribute("data5") %>
	    }, {
	        name: '50대',
	        data: <%= request.getAttribute("data6") %>
	    }, {
	        name: '60대이상',
	        data: <%= request.getAttribute("data7") %>
	    }],

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 700
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
   
<div>
<div class="jumbotron text-center">
		<div id="container2"></div>
		<p><p>
		<button id="plain" class="btn btn-sm btn-primary">막대(V)</button>
		<button id="inverted" class="btn btn-sm btn-info">막대(H)</button>
		<button id="polar" class="btn btn-sm btn-danger">레이더</button>
		<%-- <%= application.getRealPath("/")%> --%>
		<!-- /home/sist/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringBigDataMiniProject/ -->
	</div>
	
	
	    <!-- Area Chart Example-->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-chart-area"></i> 서울시 도서 맵
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-sm-5"
						style="padding-left: 200px; padding-top: 50px">
						<fieldset>
							<div id="a">
								<img id="seoul_1" src="../image/map/1111.png">
								<c:forEach var="i" step="1" begin="1" end="25">
									<a href="map.do?gu=${i }"> <img id="gu${i }"
										src="${guList[i] }"
										onmouseover="this.src='../image/map/gu_${i}_on.png'"
										onmouseout="this.src='${guList[i] }'" border=0>
									</a>
								</c:forEach>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-7">
						<div id="container1"></div>
					</div>
				</div>
			</div>
			<div class="card-footer small text-muted">Sist</div>
		</div>




	</div>
<div >
 <h1>베스트 셀러</h1>
  <div class="row">
  	<table class="table table-hover">
  		<tr class="info">
  		  <th class="text-center">년도</th>
  		  <th class="text-center">지역구</th>
  		  <th class="text-center">연령</th>
  		  <th class="text-center"></th>
  		  <th class="text-center">책 이름</th>
  		  <th class="text-center">대출 횟수</th>
  		</tr>
  		<c:forEach var="vo" items="${cList }">
  			<tr>
  			  <td class="text-center">${vo.year }</td>
  			  <td class="text-center">${vo.gu }</td>
  			  <th class="text-center">${vo.age }</th>
  			  <td class="text-center"><img src="${vo.bookImageURL }" width=100 height=100></td>
  			  <td class="text-center"><a href="../../book/detailebook/detailebook.do?bookname=${vo.bookname }&bookImageURL=${vo.bookImageURL}">${vo.bookname }</a></td>
  			  <td class="text-center">${vo.loan_count } </td>
  			</tr>
  		</c:forEach>
  	</table>
  </div>
 </div> 
</body>
</html>