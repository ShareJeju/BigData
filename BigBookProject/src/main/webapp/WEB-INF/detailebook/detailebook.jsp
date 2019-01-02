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
		<div class="container">
			<table class="table">
				<tr>
					<td width="500px">
						<table class="table" width="500px">
							<tr>
								<td rowspan="4" width=20%><img src="${bvo.bookImageURL}"
									width=300 height=450> </a></td>
								<th class="success text-center"><h1>${bvo.bookname }</h1> </a>
								</th>
							</tr>
							<tr>
								<td with=80% class="text-center"><h5>${bvo.authors}</h5></td>
							</tr>
							<tr>
								<td width=70% class="text-center"><h5>출판사 : ${bvo.publisher }</h5></td>
							</tr>
							<tr>
								<td width=70% class="text-center"><h5>출판연도 :
									${bvo.publication_year}</h5></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>

		<div class="container" style="max-width: 2000px;">
			<div class="row">
				<!-- Area Chart Example-->
				<div class="card mb-3 col-sm-6">
					<div class="card-header">
						 감성분석 그래프
					</div>
					<div class="card-body" style="height: 640px;">
						<div>
							<div id="piechart_3d" style="width: 800px; height: 620px;"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

				<div class="card mb-3 col-sm-6">
					<div class="card-header">
						연관분석 시각화
					</div>
					<div class="card-body" style="height: 640px;">
						<div>
							<img src="../book.png" width="700" height="620px;">
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>