
<jsp:include page="../common/commonfist.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>write review</title>
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
                     <div class="col-md-8">
                         <form method="post" action="submit_review" id="reviewForm">
                             <div class="form-group">
                             <div>
                             	 <div class="m-2" id="rateYo"></div>
                             	 <input type="hidden" id="rating" name="rating">
   								 <input type="hidden" name="bookId" id="bookId" value="${book.bookId}">
                             </div>
                             
                                 <input name="headline" type="text" class="form-control" id="exampleFormControlInput1" placeholder="headline">
                             </div>
                           
                            
                             <div class="form-group">
                                
                                 <textarea name="content" rows="7" class="form-control pb-4" id="exampleFormControlTextarea1"  placeholder="write detail"></textarea>
                             </div>
                            <button type="submit" class="btn btn-outline-success m-4">Submit</button>
                            <button id="btcancely" type="button" class="btn btn-outline-success m-4">cancel</button>
                         </form>
                     </div>

                 </div>
             </div>
          </div>
			
		</div>

	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="../common/commonlast.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#btcancely").click(function() {
				history.go(-1)
			})
			  $(function () {

		            $("#rateYo").rateYo({
		            	starWidth: "40px",
		                fullStar: true,
		                onSet: function (rating, rateYoInstance) {
		                	$('#rating').val(rating)
		                  },
		                  
		                  
		            });

		        });
			  
			$("#reviewForm").validate({

				rules : {
					
					headline : {
						required : true,
						
					},
					content : {
						required : true,
				
					},
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