<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<style>
/* body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
  h2 {
      font-size: 24px;
      text-transform: uppercase;
      color: #303030;
      font-weight: 600;
      margin-bottom: 30px;
  }
  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }  
  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 100px 25px;
      font-family: Montserrat, sans-serif;
  }
  .container-fluid {
      padding: 60px 50px;
  }
  .bg-grey {
      background-color: #f6f6f6;
  }
   .logo-small {
      color: #f4511e;
      font-size: 50px;
  }
  .logo {
      color: #f4511e;
      font-size: 200px;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail img {
      width: 100%;
      height: 100%;
      margin-bottom: 10px;
  }
  .carousel-control.right, .carousel-control.left {
      background-image: none;
      color: #f4511e;
  }
  .carousel-indicators li {
      border-color: #f4511e;
  }
  .carousel-indicators li.active {
      background-color: #f4511e;
  }
  .item h4 {
      font-size: 19px;
      line-height: 1.375em;
      font-weight: 400;
      font-style: italic;
      margin: 70px 0;
  }
  .item span {
      font-style: normal;
  }
  .panel {
      border: 1px solid #f4511e; 
      border-radius:0 !important;
      transition: box-shadow 0.5s;
  }
  .panel:hover {
      box-shadow: 5px 0px 40px rgba(0,0,0, .2);
  }
  .panel-footer .btn:hover {
      border: 1px solid #f4511e;
      background-color: #fff !important;
      color: #f4511e;
  }
  .panel-heading {
      color: #fff !important;
      background-color: #f4511e !important;
      padding: 25px;
      border-bottom: 1px solid transparent;
      border-top-left-radius: 0px;
      border-top-right-radius: 0px;
      border-bottom-left-radius: 0px;
      border-bottom-right-radius: 0px;
  }
  .panel-footer {
      background-color: white !important;
  }
  .panel-footer h3 {
      font-size: 32px;
  }
  .panel-footer h4 {
      color: #aaa;
      font-size: 14px;
  }
  .panel-footer .btn {
      margin: 15px 0;
      background-color: #f4511e;
      color: #fff;
  }
  .navbar {
      margin-bottom: 0;
      background-color: #f4511e;
      z-index: 9999;
      border: 0;
      font-size: 12px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
      font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
      color: #f4511e !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      color: #fff !important;
  }
  footer .glyphicon {
      font-size: 20px;
      margin-bottom: 20px;
      color: #f4511e;
  } */
/*   .slideanim {visibility:hidden;}
  .slide {
      animation-name: slide;
      -webkit-animation-name: slide;
      animation-duration: 1s;
      -webkit-animation-duration: 1s;
      visibility: visible;
  }
  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
        width: 100%;
        margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }  */
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">

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

$(function(){
	  var chart = Highcharts.chart('container1', {

		    title: {
		        text: '2018년 연령별 인기도서 200권 대출 현황'
		    },

		    subtitle: {
		        text: '남성'
		    },

		    xAxis: {
		        categories: <%= request.getAttribute("category")%>
		    },

		    series: [{
		        type: 'column',
		        colorByPoint: true,
		        data: <%= request.getAttribute("total")%>,
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
		            text: '남성'
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
		            text: '남성'
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
		            text: '남성'
		        }
		    });
		});

});

$(function(){
	  var chart = Highcharts.chart('container2', {

		    title: {
		        text: '2018년 연령별 인기도서 200권 대출 현황'
		    },

		    subtitle: {
		        text: '여성'
		    },

		    xAxis: {
		        categories: <%= request.getAttribute("wcategory")%>
		    },

		    series: [{
		        type: 'column',
		        colorByPoint: true,
		        data: <%= request.getAttribute("wtotal")%>,
		        showInLegend: false
		    }]

		});


		$('#plain2').click(function () {
		    chart.update({
		        chart: {
		            inverted: false,
		            polar: false
		        },
		        subtitle: {
		            text: '여성'
		        }
		    });
		});

		$('#inverted2').click(function () {
		    chart.update({
		        chart: {
		            inverted: true,
		            polar: false
		        },
		        subtitle: {
		            text: '여성'
		        }
		    });
		});

		$('#polar2').click(function () {
		    chart.update({
		        chart: {
		            inverted: false,
		            polar: true
		        },
		        subtitle: {
		            text: '여성'
		        }
		    });
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
   
<!-- 차트 영역 -->
<div class="row">
    <div class="col-xl-6 col-sm-12">
	<div class="text-center">
   <div id="container1"></div>
   <br>
	<button id="plain" class="btn btn-sm btn-primary">막대(V)</button>
	<button id="inverted" class="btn btn-sm btn-danger">막대(H)</button>
	<button id="polar" class="btn btn-sm btn-success">레이더</button>

<!-- 도서 정보 출력 -->
<p>
<center>
<h5>연령별 1위 도서(남성)</h5>
</center>
 
  <div id="mbook">
  
  <table class="table table-bordered">
 
    <thead>
      <tr>
      <c:forEach var="vo" items="${mbdList }">
        <th><img src="${vo.bookImageURL }" width="100" height="100"></th>
       </c:forEach>
      </tr>
    </thead>
   
    <tbody>
      <tr class="text-center">
      <c:forEach var="vo" items="${mbdList }">
        <td>${vo.age }</td>
         </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${mbdList }">
       	<td>${vo.bookname }</td>
       	 </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${mbdList }">
        <td>${vo.authors }  </td>
         </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${mbdList }">
        <td>대출:${vo.loan_count }권  </td>
         </c:forEach>
         
    </tbody>
   
  </table>
 
  </div>
</div>

</div>

 <div class="col-xl-6 col-sm-12">
 <div class="text-center">
   <div id="container2"></div>
   <br>
	<button id="plain2" class="btn btn-sm btn-primary">막대(V)</button>
	<button id="inverted2" class="btn btn-sm btn-danger">막대(H)</button>
	<button id="polar2" class="btn btn-sm btn-success">레이더</button>
</div>
<p>
<center>
<h5>연령별 1위 도서(여성)</h5>
</center>
<div id="wbook">
<table class="table table-bordered">
 
    <thead>
      <tr>
      <c:forEach var="vo" items="${wbdList }">
        <th><img src="${vo.bookImageURL }" width="100" height="100"></th>
       </c:forEach>
      </tr>
    </thead>
   
    <tbody>
      <tr class="text-center">
      <c:forEach var="vo" items="${wbdList }">
        <td>${vo.age }</td>
         </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${wbdList }">
       	<td>${vo.bookname }</td>
       	 </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${wbdList }">
        <td>${vo.authors }  </td>
         </c:forEach>
      </tr>
      <tr>
      <c:forEach var="vo" items="${wbdList }">
        <td>대출:${vo.loan_count }권  </td>
         </c:forEach>
         
    </tbody>
   
  </table>
  </div>
 </div>
</div>

		
         
          
       

</body>
</html>