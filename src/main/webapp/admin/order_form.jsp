<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>Manage Edit Order </title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light"  style="padding: 30px;">
 <h4 align="center">Edit Order id :${order.orderId}</h4>
  <h4>${message}</h4>
 
<h1 align="center">order overview</h1>
 <div class="container">

        <form action="update_order" method="post" id="orderform">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="inputEmail4">
                        <strong>orderby:${order.customer.fullname}</strong>
                    </label>

                </div>
                <div class="form-group col-md-12">
                    <label for="inputPassword4">
                        <strong>orderDate:${order.orderDate}</strong>
                    </label>

                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Recipient Name :</label>
                <input name="recipientName" type="text" class="form-control"  value="${order.recipientName}">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Recipient phone :</label>
                <input name="recipientPhone" type="text" class="form-control" value="${order.recipientPhone}">
            </div>
            <div class="form-group">
                <label for="inputAddress2">ship to :</label>
                <input name="shippingAddress" type="text" class="form-control"  value="${order.shippingAddress}">
            </div>
            <div class="form-row">
                
                <div class="form-group col-md-6">
                    <label for="inputState">paymentMethod :</label>
                    <select name="paymentMethod" id="inputState" class="form-control">
                        <option selected value="Cash on Delivery">Cash on Delivery</option>
                    
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputState">status :</label>
                    <select name="status" id="inputState" class="form-control">
                        <option value="processing" <c:if test="${order.status eq 'processing'}">selected='selected' </c:if>  >processing</option>
                      <option value="Delivered" <c:if test="${order.status eq 'Delivered'}">selected='Delivered' </c:if>>Delivered</option>
                      <option value="completed" <c:if test="${order.status eq 'completed'}">selected='completed' </c:if>>completed</option>
                       <option value="cancelled" <c:if test="${order.status eq 'cancelled'}">selected='cancelled' </c:if>>cancelled</option>
                    </select>
                </div>
            </div>
            
            
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
      <th scope="col"> action </th>
      
    </tr>
  </thead>
  <tbody>
   <c:forEach var="orderDetail" items="${order.orderDetails}" varStatus="status" >
			<tr>
				<td>${status.index+1}</td>
				<td>${orderDetail.book.title}</td>
				<td>${orderDetail.book.author}</td>
				
				<td>
					<input name="prices" type="hidden" value="${orderDetail.book.price}" />
					${orderDetail.book.price}
				
				</td>
				<td>
					<input name="bookIds" type="hidden" value="${orderDetail.book.bookId}" />
					<input name="quantity${status.index+1}" style="width:90px;" class="p-1 m-1 form-control" min="1" type="number" value="${orderDetail.quantity}">
				</td>
				<td>${orderDetail.subtotal}</td>
				<td><a class="remove_book"  href="javascript:void(0);" id="${orderDetail.book.bookId}">remove</a></td>
			

				
			</tr>
			

		</c:forEach>
		<tr>
			<th colspan="5"> total :${order.total}</th>
			
			
			</tr>
  </tbody>
</table>
            
         <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">add book</button>
            <button type="submit" class="btn btn-primary">save book</button>
            <button  type="button" onclick="javascript:window.location.href='list_order';" class="btn btn-primary">cancel book</button>
        </form>

    </div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">add book to order id :${order.orderId}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="add_book_to_order">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">select a book:</label>
                        <select name="bookId" id="inputState" class="form-control">
                        <c:forEach varStatus="status" var="book" items="${listBooks}">
                        	
                        	<option value="${book.bookId}">${book.title} - ${book.author}</option>
                        </c:forEach>
                           
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">number of copies:</label>
                        <select name="quantity" id="inputState" class="form-control">
                        <c:forEach var="j" begin="1" end="100">
                        	<option value="${j}">${j}</option>
                        </c:forEach>
                           
                        </select>
                    </div>
                    <div class="modal-footer">
                <button type="submit" class="btn btn-primary">add</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">cancel</button>
                
            </div>
                </form>
            </div>
            
        </div>
    </div>
</div>


</main>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="../common/commonlast.jsp"></jsp:include>
<script type="text/javascript">

$(document).ready(function () {
	$("#orderform").validate({

		rules : {
			
			recipientName:{
				required : true,
				
			},
			recipientPhone:{
				required : true,
				number:true,
			},
			shippingAddress:{
				required : true,
			},
			 <c:forEach var="orderDetail" items="${order.orderDetails}" varStatus="status" >
			 quantity${status.index+1}:{
				 required : true,
				 number:true,
				 min:1,
			 },
			</c:forEach>
		},
		messages : {
			

		}

	});
	
	  $(".remove_book").each(function () {
	      $(this).on("click", function () {
	       
	        bookId = $(this).attr("id");
	        if (confirm("are you sure you want to delete the book " + bookId)) {
	          window.location = 'remove_book_from_order?id=' + bookId
	        }
	      })
	    })
	    
	    
	 $('#exampleModal').on('show.bs.modal', function (event) {
	        var button = $(event.relatedTarget) 
	        var recipient = button.data('whatever') 
	        
	        var modal = $(this)
	        modal.find('.modal-title').text('New message to ' + recipient)
	        modal.find('.modal-body input').val(recipient)
	    })
	    
	    
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