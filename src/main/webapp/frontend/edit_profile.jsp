<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<title>edit My profile</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-light" style="padding: 50px 200px;" class="bg-dark text-white"
		align="center" >
		<h2>
			edit My profile
		</h2>
		<div>
			
		<form action="update_profile" method="post" id="customerForm">
				

			<table align="center">
				
				<tr>
					<td>email:</td>
					<td>${logged.email}( cannot be change)</td>
				</tr>
				<tr>
					<td>fullname:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;"
						id="fullname" type="text" name="fullname" size="50" value="${logged.fullname}"
						></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="password"
						type="password" name="password" size="50" ></td>
				</tr>
				<tr>
					<td>confirm password:</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="confirmpassword"
						type="password" name="confirmpassword" size="50" ></td>
				</tr>

				<tr>
					<td>phone number</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="phone"
						type="text" name="phone" size="50" value="${logged.phone}"></td>
				</tr>
				<tr>
					<td>address </td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="address"
						type="text" name="address" size="50" value="${logged.address}"></td>
				</tr>
				<tr>
					<td>city</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="city"
						type="text" name="city" size="50" value="${logged.city}"></td>
				</tr>
				<tr>
					<td>zipcode </td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="zipcode"
						type="text" name="zipcode" size="50" value="${logged.zipcode}"></td>
				</tr>
				<tr>
					<td>country</td>
					<td><input
						style="margin: 10px; padding: 5px; border-radius: 5px;" id="country"
						type="text" name="country" size="50" value="${logged.country}"></td>
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
		
			
			$("#customerForm").validate({

				rules : {
					email : {
						required : true,
						email:true,

					},
					fullname : {
						required : true,
					},
					password : {
						

					},
					confirmpassword : {
						
						equalTo:"#password"

					},
					city : {
						required : true,

					},
					phone : {
						required : true,
						digits:true

					},
					address :{
						required : true,
					},
					zipcode : {
						required : true,

					},
					country :{
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
	
	</script>

</body>
</html>