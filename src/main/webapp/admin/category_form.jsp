<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Create New Category</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" style="padding:50px 200px;min-height: 75vh;" class="bg-dark text-white" align="center" style="margin: 30px; ">
		<h2>
			<c:choose>
				<c:when test="${category!=null }">edit category</c:when>
				<c:otherwise>Create category</c:otherwise>
			</c:choose>
		</h2>
		<div>
			<c:choose>
				<c:when test="${category!=null }">
					<form action="update_category" method="post" id="category">
						<input type="hidden" name="categoryId"
							value="${category.categoryId}">
				</c:when>
				<c:otherwise>
					<form action="create_category" method="post" id="category">
				</c:otherwise>
			</c:choose>

			<table align="center">
				<tr>
					<td>Name:</td>
					<td><input  style="margin:10px;padding: 5px ;border-radius: 5px;" id="name" type="text" name="name" size="40"
						value="${category.name}"></td>
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

			$("#category").validate({

				rules : {
					name : {
						required : true,
						minlength:5
					},

				},
				messages : {
					name : {
						required : "please enter name",

					},

				}

			});
			
			$("#btcancely").click(function(){
				
				history.go(-1)
			})

		});
	</script>
</body>
</html>