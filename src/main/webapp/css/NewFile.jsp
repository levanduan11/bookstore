<jsp:include page="../common/commonfist.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<p>Date: <input type="text" id="datepicker"></p>





<jsp:include page="../common/commonlast.jsp"></jsp:include>
<script>
    $(function () {
        $("#datepicker").datepicker();
    });
</script>
</body>
</html>