<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>the book ${book.title} has been added to the order id ${order.orderId}</h2>
<input type="button" value="close" onclick="javascript: self.close()">
</div>
<script type="text/javascript">

	window.ounload=function(){
		window.opener.location.reload()
	}
</script>
</body>
</html>