<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Manage User List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" align="center" style="padding: 30px;">
		<h4>Book Management</h4>
		<h3>
			<a href="new_book">Create new Book</a>
		</h3>
		<div>
			<h3>${message}</h3>

		</div>

		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Index</th>
					<th scope="col">Id</th>
					<th scope="col">image</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Last Updated</th>
					<th scope="col">Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${listBooks}" varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${book.bookId}</td>
						<td><img style="width: 90px;"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqTkwFv54ld1-hPFsF24ty21Ke26zQDfPcBs4MaTxri-wmz96u5k1Xt2hq_ch5gd3JbTM&usqp=CAU"
							alt="preview"> <!-- <img style="width:70px;" src="${listImg.get(status.index)}"> -->

						</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.category.name}</td>
						<td>$${book.price}</td>
						<td>${book.lastUpdateTime}</td>

						<td><a class="text-light" href="edit_book?id=${book.bookId}">Edit</a>
							<a class="text-light deletelink" href="javascript:void(0);"
							id="${book.bookId}"> delete </a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>


	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$(".text-light.deletelink")
									.each(
											function() {
												$(this)
														.on(
																"click",
																function() {

																	bookId = $(
																			this)
																			.attr(
																					"id");
																	if (confirm("are you sure you want to delete the book "
																			+ bookId)) {
																		window.location = 'delete_book?id='
																				+ bookId
																	}
																})
											})
						});
	</script>
</body>
</html>