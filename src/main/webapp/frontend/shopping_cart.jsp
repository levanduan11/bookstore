
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<title>shopping cart</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main>

		<div class="container">

			<c:set var="cart" value="${sessionScope['cart']}">

			</c:set>
			<c:if test="${cart.totalItems==0}">
				<h3>no items</h3>

			</c:if>
			<c:if test="${cart.totalItems>0}">

				<form action="update_cart" method="post" id="cart_form">
					<div class="row ">


						<div class="col-md-9">

							<div class="row">
								<c:forEach varStatus="status" var="item" items="${cart.items}">
									<div class="col-md-12 shadow-sm m-2 p-2 border border-primary rounded ">
									
										<div class="mt-4">
											<div class="row">
												<div class="col-md-4">

													<div>
														<img style="width: 100%;"
															src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9PVc1il5E5lwqu7Hdf5sgUxCLUMJSD2ZOzg&usqp=CAU"
															alt="">
													</div>
												</div>
												<div class="col-md-4">
												
													<div>${item.key.title }</div>
													<input type="hidden" name="bookId" value="${item.key.bookId}" />
													quantity:<input name="quantity${status.index+1}" style="width:150px;" class="p-1 m-1 form-control" min="1" type="number" value="${item.value}">

												</div>
												<div class="col-md-2">
													
													<div>
													
														<p>price:<fmt:formatNumber value="${item.key.price}" type="currency" /></p> 
														<hr>
														<p>
														<fmt:formatNumber value="${item.value*item.key.price}" type="currency" /></p>  
												
														</p>
													</div>
												</div>
												<div class="col-md-2">
													<div class="row">
														<div class="col-md-12 col-4">
															<div>
																<a href="remove_from_cart?book_id=${item.key.bookId}" class="badge badge-primary">remove</a>

															</div>
														</div>

													</div>
												</div>

											</div>
										</div>

									</div>
								</c:forEach>
							</div>

						</div>



						<div class="col-md-3 p-4 ">
							<div class="row">
								<div class="col-md-12">
									<div>
										<p>total quantity:${cart.totalQuantity} books</p>
										<p>total:</p>
										<h1>
											<fmt:formatNumber value="${cart.totalAmount}" type="currency" /></p>  
										</h1>
										<div class="row">
											<div class="col-md-12">
											<a href="${pageContext.request.contextPath}/" class="border-primary badge btn-outline-primary p-3 mt-1">continue shopping</a>
											</div>
											<div class="col-md-12">
											<a style="padding:0 10px  ;" href="checkout" class="badge btn-outline-primary mt-1 p-3">check out</a>
											</div>
											
											<div class="col-md-12">
											<a href="clear_cart" class="badge btn-outline-primary p-3 mt-1">clear cart</a>
											</div>
											<div class="col-md-12">
												<input class="btn btn-outline-primary p-2 mt-1" type="submit" value="update cart">
											</div>
										
										</div>
										
									</div>
								</div>

							</div>
						</div>
					</div>
					
				</form>
					



			</c:if>



		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#cart_form").validate({

				rules : {
					<c:forEach varStatus="status" var="item" items="${cart.items}">
						
						quantity${status.index+1} :{
							required : true,
							number:true,
							min: 1,
						},
					
					
					</c:forEach>
					
				},
				messages : {
					email : {
						required : "please enter email",

					},

					password : {
						required : "please enter password",
						minlength : "lenght is greathan 8 ",
					}

				}

			});

		});
	</script>

</body>

</html>