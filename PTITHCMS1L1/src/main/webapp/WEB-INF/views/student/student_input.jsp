<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h2>SINH VIEN PTITHCM</h2>
			<form action="student/save.htm" method="post">

					<div>Ho va ten</div>
					<input name="name" />

					<div>Diem trung binh</div>
					<input name="mark" />

					<div>chuyen nganh </div>
					<label>
							<input name="major" type="radio" value="APP"/>
							Web Application
					</label>


<label>
	<input name="major" type="radio" value="WEB"/>
	Web Designer
</label>

<hr>
<button>Save</button>
</form>
</body>
</html>