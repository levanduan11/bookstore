<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Books for ${category.name}</title>
</head>
<body>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-white" align="center" style="padding: 30px;">
		<h2>${category.name}</h2>
		<div class="container">
			<div class="row">
				<c:forEach var="book" items="${listBooks}">
					<div class="col-xl-3 col-md-6">

						<div class="card shadow" style="margin: 10px 0;">
							<img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwx0e6LE4Z0RL-lxefa0DHcdfjbPL2HZr0eg&usqp=CAU">
							<div class="card-body">
								
								<p class="card-text">
									<strong>${book.title}</strong>
									
								</p>
								
								<p class="card-text">
									
								
                    				<c:forTokens var="star" items="${book.ratingStar}" delims=",">
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
                    				
                    				
								</p>
								<p class="card-text">
									$${book.price}
								</p>
								<a href="view_book?id=${book.bookId}" class="btn btn-primary">View Book</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<div></div>

	</main>

	<jsp:include page="footer.jsp"></jsp:include>




	<jsp:include page="../common/commonlast.jsp"></jsp:include>
</body>
</html>