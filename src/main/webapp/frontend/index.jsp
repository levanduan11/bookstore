<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Book Store</title>
</head>
<style>
	.card:hover {
	box-shadow:0 1px 10px ;
}
</style>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-white" align="center" style="padding: 30px;">
		
		<c:forEach varStatus="status" var="list" items="${listAll}">
			<c:set var="listitem"  value="${list}"/> 
			<h2 class="m-4">${titles[status.index]}</h2>
			
			<div class="container">
			<div class="row"> 
			<c:forEach var="book" items="${listitem}">
			<div class="col-xl-3 col-md-6">

						<div class="card" style="margin: 10px 0;">
							<img class="card-img-top"
								src=${imgs[status.index] }>
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
								
								<p class="card-text">${book.price}</p>
								<a href="view_book?id=${book.bookId}" class="btn btn-primary">View
									Book</a>
							</div>
						</div>
					</div>
			
			</c:forEach>
			</div>

		</div>
			
		</c:forEach>
		
	</main>

	<jsp:include page="footer.jsp"></jsp:include>




	<jsp:include page="../common/commonlast.jsp"></jsp:include>
</body>
</html>