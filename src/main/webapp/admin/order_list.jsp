<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>Manage Order List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light" align="center" style="padding: 30px;">
 <h4>Order Management</h4>
  <h4>${message}</h4>
 

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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="order" items="${listOrder}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td>${order.orderId}</td>
				<td>${order.customer.fullname}</td>
				<td>${order.bookCopies}</td>
				<td>${order.total}</td>
				<td>${order.paymentMethod}</td>
				<td>${order.status}</td>
				<td>${order.orderDate}</td>
				<td>
				<a class="text-light" href="view_order?id=${order.orderId}">detail</a>
					<a class="text-light" href="edit_order?id=${order.orderId}">Edit</a>
					<a class="text-light deletelink" href="javascript:void(0);" id="${order.orderId}">delete</a>

				</td>
			</tr>

		</c:forEach>
  </tbody>
</table>

</main>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="../common/commonlast.jsp"></jsp:include>
<script type="text/javascript">

$(document).ready(function () {
    $(".text-light.deletelink").each(function () {
      $(this).on("click", function () {
       
    	  orderId = $(this).attr("id");
        if(confirm("are you sure you want to delete the order "+orderId)){
    		window.location='delete_order?id='+orderId
    	}
      })
    })
  });


</script>
</body>
</html>