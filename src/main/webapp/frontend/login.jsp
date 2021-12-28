
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main>

		<div class="container">
			<div style="min-height: 100vh; padding:100px 300px;" class="bg-dark text-white">
				<h3>login</h3>
				<c:if test="${message != null}">
					<h2>${message}</h2>
				</c:if>

				<form id="loginform" action="login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							name="email" type="email" class="form-control" id="email"
							aria-describedby="emailHelp" placeholder="Enter email">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							name="password" type="password" class="form-control"
							id="password" placeholder="Password">
					</div>

					<button  style="padding:9px 40px; margin-left:200px;" type="submit" class="btn btn-primary">LogIn</button>
				</form>

			</div>
		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function() {

			$("#loginform").validate({

				rules : {
					email : {
						required : true,
						email : true
					},

					password : {
						required : true,
						minlength : 2,

					}
				},
				messages : {
					email : {
						required : "please enter email",

					},

					password : {
						required : "please enter password",
						minlength : "lenght is greathan 8 ",
					}

				}

			});

		});
	</script>

</body>

</html>