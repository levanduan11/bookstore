<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>Manage Review List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light" align="center" style="padding: 30px;">
 <h4>Review Management</h4>
  <h4>${message}</h4>
 

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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="review" items="${listReview}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td>${review.reviewId}</td>
				<td>${review.book.title}</td>
				<td>${review.rating}</td>
				<td>${review.headline}</td>
				<td>${review.customer.fullname}</td>
				<td>${review.reviewTime}</td>
				<td>
					<a class="text-light" href="edit_review?id=${review.reviewId}">Edit</a>
					<a class="text-light deletelink" href="javascript:void(0);" id="${review.reviewId}">delete</a>

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