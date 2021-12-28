<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title> Order detail</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light" align="center" style="padding: 30px;">
 <h4> Order  id :${order.orderId}</h4>
  <h4>${message}</h4>
 
<h1>order overview</h1>
<table class="table table-striped table-dark">
 
    <tr>
      <th scope="col">order by :</th>
      <th scope="col">${order.customer.fullname}</th>
      
    </tr>
     <tr>
      <th scope="col">book copies :</th>
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
  
    <tr>
      <th scope="col">status :</th>
      <th scope="col">${order.status}</th>
      
    </tr>
      <tr>
      <th scope="col">orderDate :</th>
      <th scope="col">${order.orderDate}</th>
      
    </tr>
  

</table>
<h1>order Book</h1>
<table class="table table-striped table-dark">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Index</th>
      <th scope="col">book title</th>
      <th scope="col"> author</th>
      <th scope="col"> price</th>
      <th scope="col"> quantity</th>
      <th scope="col"> subtotal</th>
      
    </tr>
  </thead>
  <tbody>
   <c:forEach var="orderDetail" items="${order.orderDetails}" varStatus="status" >
			<tr>
				<td>${status.index+1}</td>
				<td>${orderDetail.book.title}</td>
				<td>${orderDetail.book.author}</td>
				<td>${orderDetail.book.price}</td>
				<td>${orderDetail.quantity}</td>
				<td>${orderDetail.subtotal}</td>
				
			

				
			</tr>
			

		</c:forEach>
		<tr>
			<th colspan="5"> total :${order.total}</th>
			
			
			</tr>
  </tbody>
</table>


</main>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="../common/commonlast.jsp"></jsp:include>
<script type="text/javascript">

$(document).ready(function () {
    $(".text-light.deletelink").each(function () {
      $(this).on("click", function () {
       
    	  reviewId = $(this).attr("id");
        if(confirm("are you sure you want to delete the review "+reviewId)){
    		window.location='delete_review?id='+reviewId
    	}
      })
    })
  });


</script>
</body>
</html>