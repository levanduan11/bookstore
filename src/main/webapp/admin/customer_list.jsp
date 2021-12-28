<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Manage Customer List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" align="center" style="padding: 30px;">
		<h4>Customer Management</h4>
		<h3>
			<a href="customer_form.jsp">Create new Customer</a>
		</h3>
		<div>
			<h3>${message}</h3>

		</div>

		<table class="table table-striped table-dark">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Index</th>
					<th scope="col">Id</th>
					<th scope="col">Email</th>
					<th scope="col">Full Name</th>
					<th scope="col">City</th>
					<th scope="col">country</th>
					<th scope="col">Registered Date</th>
					<th scope="col">Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${listCustomer}"
					varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${customer.customerId}</td>
						<td>${customer.email}</td>
						<td>${customer.fullname}</td>
						<td>${customer.city}</td>
						<td>${customer.country}</td>
						<td>${customer.registerDate}</td>


						<td><a class="text-light"
							href="edit_customer?id=${customer.customerId}">Edit</a> <a
							class="text-light deletelink" href="javascript:void(0);"
							id="${customer.customerId}"> delete </a></td>
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
	  $(document).ready(function () {
          $(".text-light.deletelink").each(function () { 
              $(this).on("click", function () {
                   customerId = $( this).attr("id");
                    
                  if (confirm("are you sure you want to delete the customer "
                      + customerId)) {
                      window.location = 'delete_customer?id='
                          + customerId
                  }
              }); 
          });
      });
	</script>
</body>
</html>