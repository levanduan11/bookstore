<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Edit Review</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" style="padding:50px 200px;min-height: 75vh;" class="bg-dark text-white" align="center" style="margin: 30px; ">
		<h2>
			edit review
		</h2>
		<div>
			
		<form action="update_review" method="post" id="reviewForm">
		<input type="hidden" name="reviewId" value="${review.reviewId}" />	
			<table align="center">
				<tr>
					<td>book:</td>
					<td>${review.book.title}</td>
				</tr>
				<tr>
					<td>rating:</td>
					<td>${review.rating}</td>
				</tr>
				<tr>
					<td>customer:</td>
					<td>${review.customer.fullname}</td>
				</tr>
				<tr>
					<td>headline:</td>
					<td>
						<input id="headline" type="text" name="headline" value="${review.headline}" />
					</td>
				</tr>
					<tr>
					<td>comment:</td>
					<td>
						<textarea id="comment" type="text" name="comment">
							${review.comment}
						</textarea>
					</td>
				</tr>
				

				<tr>
					<td colspan="2" align="center" style="margin: 20px;"><input
						type="submit" value="save" style="margin:10px;padding: 5px 40px ;border-radius: 5px;">
						 <input style="margin:10px;padding: 5px 40px;border-radius: 5px ;" type="button"
						value="cancel" id="btcancely">
						
						</td>

				</tr>

			</table>

			</form>

		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#reviewForm").validate({
				
				rules:{
					headline:"required",
					comment:"required",
				}
				

			});
			
			$("#btcancely").click(function(){
				
				history.go(-1)
			})

		});
	</script>
</body>
</html>