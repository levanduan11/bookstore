<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Book Store</title>
</head>
<body>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="bg-dark text-white" align="center" style="padding: 30px;">

		<h2>Welcome ,${logged.fullname}</h2>
	

<div style="margin:20px 200px;padding:100px; border-radius: 10px; font-weight: 700 ;font-size:20px ;" class="bg-light">
<table  class="table">

  <tbody>
    <tr>
     
      <td>Email Address</td>
      <td>${logged.email}</td>
      
    </tr>
    <tr>
     
      
      <td>full name</td>
      <td>${logged.fullname}</td>
    </tr>
    <tr>
       <td>phone number</td>
      <td>${logged.phone}</td>
    </tr>
    <tr>
       <td>address</td>
      <td>${logged.address}</td>
    </tr>
     <tr>
       <td>city</td>
      <td>${logged.city}</td>
    </tr>
    <tr>
       <td>zipcode</td>
      <td>${logged.zipcode}</td>
    </tr>
    <tr>
       <td>country</td>
      <td>${logged.country}</td>
    </tr>
    <tr>
    	<td>
    		<a href="edit_profile" class="btn btn-primary btn-lg active">
    			Edit
    		</a>
    	</td>
    </tr>
   
  </tbody>
</table>

</div>

	</main>

	<jsp:include page="footer.jsp"></jsp:include>




	<jsp:include page="../common/commonlast.jsp"></jsp:include>
</body>
</html>