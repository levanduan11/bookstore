<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>My Order detail</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" align="center" style="padding: 30px;">
		<c:if test="${order==null}">
			<h2>sorry, you are not authorized to view this order</h2>
		</c:if>

		<c:if test="${order!=null}">
			<h4>Your Order detail id :${order.orderId}</h4>



			<table class="table table-striped table-dark">


				<tr>
					<th scope="col">status :</th>
					<th scope="col">${order.status}</th>

				</tr>
				<tr>
					<th scope="col">orderDate :</th>
					<th scope="col">${order.orderDate}</th>

				</tr>

				<tr>
					<th scope="col">quan tity :</th>
					<th scope="col">${order.bookCopies}</th>

				</tr>
				<tr>
					<th scope="col">total Amount :</th>
					<th scope="col">${order.total}</th>

				</tr>
				<tr>
					<th scope="col">Recipient Name :</th>
					<th scope="col">${order.recipientName}</th>

				</tr>
				<tr>
					<th scope="col">Recipient phone :</th>
					<th scope="col">${order.recipientPhone}</th>

				</tr>
				<tr>
					<th scope="col">paymentMethod :</th>
					<th scope="col">${order.paymentMethod}</th>

				</tr>
				<tr>
					<th scope="col">shippingAddress :</th>
					<th scope="col">${order.shippingAddress}</th>

				</tr>


			</table>
			<h1>order Book</h1>
			<table class="table table-striped table-dark">
				<thead class="thead-dark">
					<tr>
						<th scope="col">No</th>

						<th scope="col">book</th>
						<th scope="col">author</th>
						<th scope="col">price</th>
						<th scope="col">quantity</th>
						<th scope="col">subtotal</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderDetail" items="${order.orderDetails}"
						varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td><img style="width: 100px; border-radius: 10px;" class=""
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNliDRzBUpcIS7Zu2rbXQsEXOUWstsS8SXYw&usqp=CAU"
								alt="Card image cap">
								<p>${orderDetail.book.title}</p></td>
							<td>${orderDetail.book.author}</td>
							<td>${orderDetail.book.price}</td>
							<td>${orderDetail.quantity}</td>
							<td>${orderDetail.subtotal}</td>

						</tr>


					</c:forEach>
					<tr>
						<th colspan="5">
							<h3>total :${order.total}</h3>


						</th>


					</tr>
				</tbody>
			</table>
		</c:if>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>

</body>
</html>