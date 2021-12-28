<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<title>Create New Book</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" style="padding: 50px 200px;" class="bg-dark text-white"
		align="center" style="margin: 30px; min-height: 62vh;">
		<h2>
			<c:choose>
				<c:when test="${book!=null }">edit Book</c:when>
				<c:otherwise>Create new Book</c:otherwise>
			</c:choose>
		</h2>
		<div>
			<c:choose>
				<c:when test="${book!=null }">
					<form action="update_book" method="post" id="bookForm">
						<input type="hidden" name="bookId" value="${book.bookId}">
				</c:when>
				<c:otherwise>
					<form action="create_book" method="post" id="bookForm">
				</c:otherwise>
			</c:choose>

			<table align="center">
				<tr>
					<td>Category:</td>
					<td><select
						style="margin: 10px; padding: 9px 15px; border-radius: 5px;"
						name="category">
							<c:forEach var="category" items="${listCategory}">
								<c:if test="${category.categoryId eq book.category.categoryId }">
									<option value="${category.categoryId}" selected>
									${category.name}</option>
								</c:if>
								<c:if test="${category.categoryId ne book.category.categoryId }">
									<option value="${category.categoryId}">
									${category.name}</option>
								</c:if>
								
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="title"
						type="text" name="title" size="50" value="${book.title}"></td>
				</tr>
				<tr>
					<td>Author:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;"
						id="author" type="text" name="author" size="50"
						value="${book.author}"></td>
				</tr>
				<tr>
					<td>isbn:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="isbn"
						type="text" name="isbn" size="50" value="${book.isbn}"></td>
				</tr>
				<tr>
					<td>Publish Date:</td>
					<td><input autocomplete="off"
						style="margin: 10px; padding: 5px; border-radius: 5px;"
						id="publishDate" type="text" name="publishDate" size="50"
						value="<fmt:formatDate pattern='MM/dd/yyyy' value='${book.publishDate}'/>"></td>
				</tr>

				<tr>
					<td>Book img:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="image"
						type="file" name="image" size="50" value="${book.image}">
						<img id="thumbnail" alt="preview" src=""></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="price"
						type="text" name="price" size="50" value="${book.price}"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td>
						<textarea  style="border-radius: 10px;" rows="5" cols="53"
							 name="description" id="descriptionu">
                        			${book.description}
                    	</textarea>
                    </td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="margin: 20px;"><input
						style="margin: 10px; padding: 5px 29px; border-radius: 5px;"
						type="submit" value="save"> <input
						style="margin: 10px; padding: 5px 29px; border-radius: 5px;"
						type="button" value="cancel" id="btcancely"></td>

				</tr>

			</table>
			</form>

		</div>
	</main>

	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#publishDate").datepicker();
			$('#image').change(function() {
				showImageThumbnail(this)
			})
			$("#bookForm").validate({

				rules : {
					title : {
						required : true,

					},
					author : {
						required : true,
					},
					isbn : {
						required : true,

					},
					publishDate : {
						required : true,

					},
					
					price : {
						required : true,

					},
					description :{
						required : true,
					},
						

					
				},
				messages : {
					title : {
						required : "please enter title",

					},
					author : {
						required : "please enter author",
					},
					isbn : {
						required : "please enter isbn",

					},
					publishDate : {
						required : "please enter publishDate",
					},
					
					price : {
						required : "please enter price",
						digits:true,
					},
					description : {
						required : "please enter description",

					},



				}

			});
			$("#btcancely").click(function() {
				history.go(-1)
			})

		});
		function showImageThumbnail(fileInput) {
			var file = fileInput.files[0];
			var reader = new FileReader();
			reader.onload = function(e) {
				$('thumbnail').attr('src', e.target.result);
			};
			reader.readAsDataURL(file);
		}
	</script>

</body>
</html>