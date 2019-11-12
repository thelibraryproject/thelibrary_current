<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/template/header.jsp"%>

<div class="row">
	<div class="col">
		<div id="libraryCarousel" class="carousel slide my-2"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img height=150px " src="img/bookshop1.jpg" class="d-block w-100"
						alt="bookshop1">
				</div>
				<div class="carousel-item">
					<img height=150px " src="img/bookshop2.jpg" class="d-block w-100"
						alt="bookshop2">
				</div>
				<div class="carousel-item">
					<img height=150px " 	src="img/library1.jpg" class="d-block w-100"
						alt="library1">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Precedente</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Successivo</span>
			</a>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
