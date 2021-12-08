<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>${title}</title>
</head>
<body>

<body>
	<div class="container">
		<div class="jumbotron" style="margin: 45px 0px">
			<h2 class="text-center">Note CRUD APP</h2>
		</div>

		<form method="POST" action="saveNews" modelAttribute="news">

			<div class="form-group">
				<label for="newsid">News ID</label> <input type="text"
					class="form-control" id="newsId" aria-describedby="name"
					placeholder="Enter News ID" name="newsId">
			</div>

			<div class="form-group">
				<label for="exampleInputTitle">News Title</label>
				<input type="text"
					class="form-control" id="newsTitle" aria-describedby="name"
					placeholder="Enter News Title" name="newsTitle">
			</div>

			<div class="form-group">
				<label for="exampleInputNoteText">Note Text</label>
				<input type="text" class="form-control" id="noteText"
					placeholder="Enter News Text" name="newsText">
			</div>

			<div class="form-group">
				<label for="exampleInputNoteCategory">Note Category</label>
				<input type="text" class="form-control" id="newsCategory"
					placeholder="Enter News Category" name="newsCategory">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


    <h2>All News Information</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>NEWSID</th>
                <th>NEWS TITLE</th>
                <th>NEWS TEXT</th>
                <th>NEWS CATEGORY</th>
            </tr>
        </thead>
        <tbody id="table-body">
            <c:forEach items="${newsList}" var="newsObj">
                <tr>
                    <td>${newsObj.newsId}</td>
                    <td>${newsObj.newsTitle}</td>
                    <td>${newsObj.newsText}</td>
                    <td>${newsObj.newsCategory}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>
