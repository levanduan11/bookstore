




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header  class="bg-secondary text-white">
	
	<div class="p-3">
	Welcom Admin ${sessionScope.useremail} | <a class="text-light" href="logout">Logout</a>
	</div>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/">BookStore</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item ">
        <a class="nav-link" href="list_users">User <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list_category">Category</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list_books">Books</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list_customer">Customer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list_review">Reviews</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list_order">Order</a>
      </li>
     
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

</header>
