<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>My order History</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" align="center" style="padding: 30px;">
		<h4>My order history</h4>


		<c:if test="${listOrders.size()==0 }">
			<h3>you have not placed orders</h3>

		</c:if>

		<c:if test="${listOrders.size()>0 }">



			<table class="table table-striped table-dark">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Index</th>
						<th scope="col">Order Id</th>
						<th scope="col">Quantity</th>
						<th scope="col">Total Amount</th>
						<th scope="col">Status</th>
						<th scope="col">Order date</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${listOrders}" varStatus="status">
						<tr>
							<td>${status.index}</td>
							<td>${order.orderId}</td>
							
							<td>${order.bookCopies}</td>
							<td>${order.total}</td>
							
							<td>${order.status}</td>
							<td>${order.orderDate}</td>
							<td>
							<a class="text-light"
								href="view_order?id=${order.orderId}">view detail</a> </td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	
</body>
</html>