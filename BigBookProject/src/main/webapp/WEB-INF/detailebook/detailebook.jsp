<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ '감성', '감성 수치' ],
				<c:forEach var="vo" items="${list}">[
						'<c:out value="${vo.feel}"/>',
						<c:out value="${vo.count}"/>], </c:forEach> ]);

		var options = {
			title : 'Book 감성분석 현황',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<%-- <%= application.getRealPath("/")%> --%>
	<div class="container-fluid">
		<div class="row">			
		<div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-chart-area"></i>
            <h2>책 제목 : ${bookname }</h2></div>
            <div class="card-body">
		           <div>
						<img src="${bookImageURL}" width=500 height=500 />
					</div>
					<div>
					   <h5>만든이 : ${authors} </h5><br><hr>
					   <h5>출판사 : ${publisher }</h5><br><hr>
					   <h5>출판연도 : ${publication_year}</h5><hr>
					</div>
			<br>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
			
			
		</div>
		<div class="row">
		  <!-- Area Chart Example-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-chart-area"></i>
              감성분석 그래프</div>
				<div class="card-body" style="height: 640px;">
					<div class="col-sm-6">
						<div id="piechart_3d" style="width: 800px; height: 620px;"></div>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
                    
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-chart-area"></i>
             연관분석 시각화</div>
            <div class="card-body" style="height: 640px;">
             <div class="col-sm-6" >
				<img src="../book.png" width="700" height="620px;">
			</div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          
		</div>
	</div>
</body>
</html>