<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<title>Manage User List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="bg-light" align="center" style="padding: 30px;">
 <h4>User Management</h4>
 	<h3><a href="user_form.jsp">Create new User</a></h3>
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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="user" items="${listUser}" varStatus="status" >
			<tr>
				<td>${status.index}</td>
				<td>${user.userId}</td>
				<td>${user.email}</td>
				<td>${user.fullName}</td>
				<td>
					<a class="text-light" href="edit_user?id=${user.userId}">Edit</a>
					<a class="text-light deletelink" href="javascript:void(0);"  id="${user.userId}">
						delete
					</a>
					
					
				</td>
			</tr>
		
		</c:forEach>
  </tbody>
</table>
	

</main>
<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="../common/commonlast.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script type="text/javascript">

$(document).ready(function () {
    $(".text-light.deletelink").each(function () {
      $(this).on("click", function () {
       
        userId = $(this).attr("id");
        if (confirm("are you sure you want to delete the user " + userId)) {
          window.location = 'delete_user?id=' + userId
        }
      })
    })
    
    
  });

function confirmDele(userId) {
	if(confirm("are you sure you want to delete the user "+userId)){
		window.location='delete_user?id='+userId
	}
	
}
</script>
</body>
</html>