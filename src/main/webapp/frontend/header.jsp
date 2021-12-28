
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="header" align="center">

	<div class="p-2 bg-dark text-white">
	
		<c:if test="${logged==null}">
			<a class="text-light mr-2" href="login">login |</a>
			<a class="text-light mr-2" href="register">Register |</a>
		
		</c:if>
		<c:if test="${logged!=null}">
				<a class="text-light mr-2" href="view_profile">Welcome ${logged.fullname} |</a>
				<a class="text-light mr-2" href="view_orders">My order |</a>
				<a class="text-light mr-2" href="logout">Logout |</a>
		</c:if>
			<a class="text-light mr-2" href="view_cart">Cart</a>
		

	</div>

	<nav style="background-color: #e3f2fd;" class="navbar navbar-expand-sm navbar-light bg-light ">
		<a style="font-weight: 700;" class="navbar-brand text-success" href="${pageContext.request.contextPath}">BookStore</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

				<c:forEach var="category" items="${listCategory}" varStatus="status">
				
					<li class="nav-item"><a href="view_category?id=${category.categoryId}" class="nav-link">${category.name}</a>
					</li>

				</c:forEach>



			</ul>
				
			<form action="search" method="get" class="form-inline my-2 my-lg-0">
				<input name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search Book">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

</header>



