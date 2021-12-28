<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>Manage User List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light" align="center" style="padding: 30px;">
 <h4>Category Management</h4>
 	<h3><a href="category_form.jsp">Create new Category</a></h3>
	<div>
		<h3>${message}</h3>

	</div>

<table class="table table-striped table-dark">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Index</th>
      <th scope="col">Id</th>
      <th scope="col"> Name</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="category" items="${listCategory}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td>${category.categoryId}</td>
				<td>${category.name}</td>
				<td>
					<a class="text-light" href="edit_category?id=${category.categoryId}">Edit</a>
					<a class="text-light deletelink" href="javascript:void(0);" id="${category.categoryId}">delete</a>

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
       
    	  categoryId = $(this).attr("id");
        if(confirm("are you sure you want to delete the category "+categoryId)){
    		window.location='delete_category?id='+categoryId
    	}
      })
    })
  });

function confirmDele(categoryId) {
	if(confirm("are you sure you want to delete the category "+categoryId)){
		window.location='delete_category?id='+categoryId
	}

}
</script>
</body>
</html>