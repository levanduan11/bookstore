
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<title>check out</title>
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
					<h5>
						Review Your Order Details 
						<a href="view_cart">edit</a>
					</h5>
		
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
																quantity: <h4>${item.value}</h4>

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
											
										
										</div>
										
									</div>
								</div>

							</div>
						</div>
					</div>
					
		<form style="margin:50px 0; padding:40px;" class="shadow rounded bg-dark text-white" action="place_order" method="post" id="orderForm">
              <div class="form-row">
                  <div class="form-group col-md-6">
                      <label for="inputEmail4">recipientName</label>
                      <input name="recipientName" type="text" class="form-control" id="inputEmail4" value="${logged.fullname}">
                  </div>
                  <div class="form-group col-md-6">
                      <label for="inputPassword4">recipientPhone</label>
                      <input name="recipientPhone" type="text" class="form-control" id="inputPassword4" value="${logged.phone}">
                  </div>
              </div>
              <div class="form-group">
                  <label for="inputAddress">Address</label>
                  <input name="address" type="text" class="form-control" id="inputAddress" value="${logged.address}">
              </div>
              <div class="form-group">
                  <label for="inputAddress2">country</label>
                  <input name="country" type="text" class="form-control" id="inputAddress2" value="${logged.country}">
              </div>
              <div class="form-row">
                  <div class="form-group col-md-6">
                      <label for="inputCity">City</label>
                      <input name="city" type="text" class="form-control" id="inputCity" value="${logged.city}">
                  </div>
                  <div class="form-group col-md-4">
                      <label for="inputState">Payment</label>
                      <select name="payment" id="inputState" class="form-control">
                          <option selected>cash on deliveri</option>
                          
                      </select>
                  </div>
                  <div class="form-group col-md-2">
                      <label for="inputZip">Zip code</label>
                      <input name="zipcode" type="text" class="form-control" id="inputZip" value="${logged.zipcode}">
                  </div>
              </div>
            
              <button type="submit" class="btn btn-primary">place order</button>
          </form>
					
			
					



			</c:if>



		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#orderForm").validate({

				rules : {
					recipientName :{
						required:true,
					},
					recipientPhone :{
						required:true,
						number:true,
					},
					address :{
						required:true,
					},
					country :{
						required:true,
					},
					city :{
						required:true,
					},
					zipcode :{
						required:true,
					},
					
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