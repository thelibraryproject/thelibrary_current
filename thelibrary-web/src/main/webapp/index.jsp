<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>The Library application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="styles/heroic-features.css" rel="stylesheet">

<link rel="stylesheet" href="styles/thelibrary.css">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">The Library</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
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
		<div id="books" col="row">
			<div class="media my-3">
				<img src="img/gof.jpg" class="bookCover align-self-start mr-3"
					alt="...">
				<div class="media-body">
					<h5 class="mt-0">Design Patterns: Elements of Reusable
						Object-Oriented Software</h5>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">Erich Gamma</li>
						<li class="list-group-item">Ruchard Helm</li>
						<li class="list-group-item">Ralph Johnson</li>
						<li class="list-group-item">John Vlissides</li>
					</ul>
					<p>Capturing a wealth of experience about the design of
						object-oriented software, four top-notch designers present a
						catalog of simple and succinct solutions to commonly occurring
						design problems. Previously undocumented, these 23 patterns allow
						designers to create more flexible, elegant, and ultimately
						reusable designs without having to rediscover the design solutions
						themselves.</p>

					<p>The authors begin by describing what patterns are and how
						they can help you design object-oriented software. They then go on
						to systematically name, explain, evaluate, and catalog recurring
						designs in object-oriented systems. With Design Patterns as your
						guide, you will learn how these important patterns fit into the
						software development process, and how you can leverage them to
						solve your own design problems most efficiently.</p>

					<p>Each pattern describes the circumstances in which it is
						applicable, when it can be applied in view of other design
						constraints, and the consequences and trade-offs of using the
						pattern within a larger design. All patterns are compiled from
						real systems and are based on real-world examples. Each pattern
						also includes code that demonstrates how it may be implemented in
						object-oriented programming languages like C++ or Smalltalk.</p>
					<div>
						<a
							href="https://www.amazon.it/Design-Patterns-Object-Oriented-Addison-Wesley-Professional-ebook/dp/B000SEIBB8"
							class="btn btn-primary" role="button">Compra su Amazon</a>
					</div>
				</div>
			</div>
			<div class="media my-3">
				<img src="img/harrypotter.jpg" class="bookCover align-self-start mr-3"
					alt="Harry Potter">
				<div class="media-body">
					<h5 class="mt-0">Harry Potter and the Philosopher's Stone</h5>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">J.K. Rowling</li>
					</ul>
					<p>Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. Then, on Harry's eleventh birthday, a great beetle-eyed giant of a man called Rubeus Hagrid bursts in with some astonishing news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!</p>
					<div>
						<a
							href="https://www.amazon.it/Harry-Potter-Philosophers-Stone-English-ebook/dp/B019PIOJYU"
							class="btn btn-primary" role="button">Compra su Amazon</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>

</html>