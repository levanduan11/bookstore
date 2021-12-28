
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>write review</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="bg-transparent" style="min-height: 90vh;">

		<div class="container">
			<div class="row">
				<div class="col-md-12 p-3 border-bottom mt-4">
					<div class="row">
						<div class="col-md-2">
							<p class="text-uppercase">your already wrote a review for
								this book</p>
						</div>
						<div class="col-md-8"></div>
						<div class="col-md-2">
							<h5 class="text-uppercase">${logged.fullname}</h5>
						</div>
					</div>
				</div>
				<div class="col-md-12 mt-4">
					<div class="row">
						<div class="col-md-4">
							<div class="card shadow-sm  bg-white rounded">
								<div class="card-body p-2 text-center">
									<h5 class="card-title ">${book.title}</h5>

								</div>
								<img class="card-img-bottom"
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVDLaayiusRfYPvMTfnpC_DlICzc7iQwJpIg&usqp=CAU"
									alt="Card image cap">
							</div>
						</div>
						<div class="col-md-8">
							<form>
								<div class="form-group">
									<div>
										<div class="m-2" id="rateYo"></div>
										<input type="hidden" id="rating" name="rating"> <input
											type="hidden" name="bookId" id="bookId"
											value="${book.bookId}">
									</div>

									
								</div>


							</form>
							<div class="card">
								<div class="card-header">${review.headline}</div>
								<div class="card-body">
									<blockquote class="blockquote mb-0">
										<p>${review.comment}.</p>
										
									</blockquote>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>

	<script type="text/javascript">
	  $("#rateYo").rateYo({
       	rating: ${review.rating},
        fullStar: true,
        readOnly:true,
             
             
       });
	
	</script>

</body>

</html>