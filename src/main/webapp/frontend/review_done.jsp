
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>review posted</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="bg-transparent" style="min-height: 90vh;">

		<div class="container">
			   <div class="row">
             <div class="col-md-12 p-3 border-bottom mt-4">
                 <div class="row">
                     <div class="col-md-2"><h5 class="text-uppercase">your review</h5></div>
                    <div class="col-md-8"></div>
                    <div class="col-md-2"><h5 class="text-uppercase">${logged.fullname}</h5></div>
                 </div>
             </div>
             <div class="col-md-12 mt-4">
                 <div class="row">
                     <div class="col-md-4">
                            <div class="card shadow-sm  bg-white rounded">
                                <div class="card-body p-2 text-center">
                                    <h5 class="card-title ">${book.title}</h5>
                                    
                                </div>
                                <img class="card-img-bottom" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVDLaayiusRfYPvMTfnpC_DlICzc7iQwJpIg&usqp=CAU" alt="Card image cap">
                            </div>
                     </div>
                	<h2>your review has been posted </h2>

                 </div>
             </div>
          </div>
			
		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	
	

</body>

</html>