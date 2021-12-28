
<jsp:include page="../common/commonfist.jsp"></jsp:include>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" align="center" style="padding: 30px;">
		<h4>Administrative Dashboard</h4>
		<div>
			<hr width="57%" />
			<h2>Quick Actions</h2>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link" href="new_book">New
						book</a></li>
				<li class="nav-item"><a class="nav-link" href="user_form.jsp">New
						user</a></li>
				<li class="nav-item"><a class="nav-link" href="category_form.jsp">New
						Category</a></li>
				<li class="nav-item"><a class="nav-link " href="customer_form.jsp">New
						Customer</a></li>
			</ul>

		</div>

		<div>
			<hr width="57%" />
			<h2>Recent Sales:</h2>
			<table class="table table-striped table-dark">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Index</th>
      <th scope="col">Order Id</th>
      <th scope="col"> Order BY</th>
      <th scope="col"> Book Copies</th>
      <th scope="col"> Total</th>
      <th scope="col"> Payment method</th>
      <th scope="col"> Status</th>
       <th scope="col"> Order date</th>

    </tr>
  </thead>
  <tbody>
   <c:forEach var="order" items="${listRecentSales}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td><a class="text-light" href="view_order?id=${order.orderId}">${order.orderId}</a></td>
				<td>${order.customer.fullname}</td>
				<td>${order.bookCopies}</td>
				<td>${order.total}</td>
				<td>${order.paymentMethod}</td>
				<td>${order.status}</td>
				<td>${order.orderDate}</td>
				<td>
				
				</td>
			</tr>

		</c:forEach>
  </tbody>
</table>
			
		</div>

		<div>
			<hr width="57%" />
			<h2>Recent Reviews:</h2>
			<table class="table table-striped table-dark">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Index</th>
      <th scope="col">Id</th>
      <th scope="col"> Book</th>
      <th scope="col"> Rating</th>
      <th scope="col"> Headline</th>
      <th scope="col"> Customer</th>
      <th scope="col"> Review on</th>
     
    </tr>
  </thead>
  <tbody>
   <c:forEach var="review" items="${listRecentReviews}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td>${review.reviewId}</td>
				<td> ${review.book.title}</td>
				<td>${review.rating}</td>
				<td> <a class="text-light" href="edit_review?id=${review.reviewId}">${review.headline}</a></td>
				<td>${review.customer.fullname}</td>
				<td>${review.reviewTime}</td>
				
			</tr>

		</c:forEach>
  </tbody>
</table>
			
		</div>

		<div>
			<hr width="57%" />
			<h2>Statistics:</h2>
			<ul class="list-group flex-row justify-content-center m-4">
			<c:forEach var="total" varStatus="status" items="${totals}">
				<li class="list-group-item">${names[status.index]}: <strong>${total}</strong> </li>
			</c:forEach>
  
			</ul>
		</div>

	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
</body>
</html>