<jsp:include page="../common/commonfist.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<title>Create New user</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main style="padding:100px 200px;min-height: 75vh;" class="bg-dark text-white" align="center" style="margin: 30px; min-height: 62vh;">
   <h2>
   		<c:choose>
   			<c:when test="${user!=null }">edit user</c:when>
   			<c:otherwise>Create Form</c:otherwise>
   		</c:choose>
   </h2>
  <div>
  	<c:choose>
   		<c:when test="${user!=null }"> 
        <form action="update_user" method="post" id="userForm">
          <input type="hidden" name="userId" value="${user.userId}">
      </c:when>
   		<c:otherwise> <form action="create_user" method="post" id="userForm"></c:otherwise>
   	</c:choose>
   
         <table align="center">
          <tr>
              <td>Email:</td>
              <td><input style="margin:10px;padding: 5px; border-radius: 5px;" id="email" type="email" name="email" size="50" value="${user.email}"></td>
          </tr>
          <tr>
              <td>Fullname:</td>
              <td><input style="margin:10px;padding: 5px; border-radius: 5px;"  id="fullname" type="text" name="fullname" size="50" value="${user.fullName}"></td>
          </tr>
          <tr>
              <td>password:</td>
              <td><input style="margin:10px;padding: 5px;border-radius: 5px;" id="password" type="password" name="password" size="50" value="${user.password}"></td>
          </tr>
            <tr>
                <td colspan="2" align="center" style="margin: 20px;">
                    <input style="margin:10px;padding:5px 29px;border-radius:5px;" type="submit" value="save">
                    <input style="margin:10px;padding:5px 29px;border-radius:5px;" type="button" value="cancel" id="btcancely">
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
    
    $("#userForm").validate({  
        
        rules: {
        	email: {  
                required: true,
                email: true
            },
            fullname: {
                required: true
            },
            password: {
                required: true,
                minlength:1,
               
            }
        },
        messages:{
        	email:{
        		required:"please enter email",
            	
        	},
        	fullname:{
        		required:"please enter fullname",
        	},
        	password:{
        		required:"please enter password",
        		minlength:"lenght is greathan 8 ",
        	}
        
        	
        }
        
    
    });
    $("#btcancely").click(function(){
    	history.go(-1)
    })

});
</script>
</body>
</html>