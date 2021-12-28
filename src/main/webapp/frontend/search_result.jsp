<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<title>Result for ${keyword}</title>
</head>
<body>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="" align="center" style="padding: 30px;">
		<c:if test="${fn:length(search)==0 }">
			<h2>No result for "${keyword}"</h2>
		</c:if>
		<c:if test="${fn:length(search)>0}">
		<h2>Result for "${keyword}"</h2>
		
		
		  <div class="container">
        <div class="row">
			<c:forEach var="book" items="${search}">
            <div style="padding: 20px 10px;" class="col-12 mb-5 border  rounded-right bg-white shadow">
                <div class="row">
                    <div class="col-md-3">
                        <img  src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuggm-j2Vb-xWQ5b5KD9OOTXu7CIytr2UGMA&usqp=CAU"
                            class="img-fluid rounded" alt="Responsive image">
                    </div>
                    <div class="col-md-6">
                        <div class="card" style="">
                            <div class="card-header">
                                <strong>${book.title}</strong>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
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

                                </li>
                                <li class="list-group-item">
                             		${book.author}

                                </li>
                                <li class="list-group-item">
                                	${fn:substring(book.description, 0, 100)}  
									...
                                
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">$${book.price}</li>
                                <li class="list-group-item"><a href="#">Add To Cart</a></li>
								<li class="list-group-item">
									<a href="view_book?id=${book.bookId}" class="btn btn-primary btn-lg active">
										View Book Detail
									</a>
								</li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            </c:forEach>

        </div>
    </div>
			
		</c:if>
	</main>

	<jsp:include page="footer.jsp"></jsp:include>




	<jsp:include page="../common/commonlast.jsp"></jsp:include>
</body>
</html>