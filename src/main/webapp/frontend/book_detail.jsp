<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<title>${book.title}</title>
</head>
<body>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-white " align="center" style="padding: 30px;">

		<div style="padding: 30px;" class="container bg-transparent shadow">
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<img style="width: 100%;"
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFlcYHaKpW6d8wDSBeThBMpvM3JgIkLaj-TEoSbDY-fMC2skNV4u_dW3IYe3F9USgcQfc&usqp=CAU"
						class="" alt="Responsive image">


					<div class="mt-3">
						<c:forEach var="review" items="${book.reviews}">
							<li class="list-group-item  mt-3"><c:forTokens var="star"
									items="${review.stars}" delims=",">
									<c:if test="${star eq 'off' }">
										<i class="fas fa-star"></i>
									</c:if>
									<c:if test="${star eq 'on' }">
										<i class="fas fa-star text-warning"></i>
									</c:if>


								</c:forTokens> <strong>${review.headline}</strong> <br> <strong>by
									${review.customer.fullname } on ${review.reviewTime}</strong> <br>
								<p>${review.comment}</p></li>

						</c:forEach>

					</div>
				</div>
				<div class="col-md-8 col-sm-12">
					<div class="card" style="">

						<div class="card-body">
							<h5 class="card-title">
								<strong>${book.title} by ${book.author} </strong>
							</h5>
							<p class="card-text">${book.description}</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">
								<c:forTokens var="star"
									items="${book.ratingStar}" delims=",">
									<c:if test="${star eq 'off' }">
										<i class="fas fa-star"></i>
									</c:if>
									<c:if test="${star eq 'on' }">
										<i class="fas fa-star text-warning"></i>
									</c:if>
									<c:if test="${star eq 'half' }">
										<i class="fas fa-star-half-alt text-warning"></i>
									</c:if>

								</c:forTokens>
								<a href="#">${fn:length(book.reviews) } Reviews</a>
								
							</li>


							<li class="list-group-item text-danger">$${book.price}</li>
							<li class="list-group-item">
								
									<a style="padding:5px 10px;" href="add_to_cart?bookId=${book.bookId}" class="badge badge-warning">Add
									to Cart</a>
							</li>
							<div class="form-group">
								
								<button id="writeReview" type="" class="btn btn-outline-primary m-4">Write Reiview</button>

							</div>

						</ul>
						
					</div>
				</div>
			</div>
		</div>


	</main>

	<jsp:include page="footer.jsp"></jsp:include>

	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function () {
			$("#writeReview").click(function() {
				window.location='write_review?bookId=' +${book.bookId};
			})
		})
	
	
	</script>
</body>
</html>