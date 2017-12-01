<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iris Machine Learning</title>
</head>
<body>
	<div id="principal">
		<form action="iris" method="post">
			<input type="number" step="0.1" name="sepalLength"
				placeholder="Sepal Length"><br /> <input type="number"
				step="0.1" name="sepalWidth" placeholder="Sepal Width"><br />
			<input type="number" step="0.1" name="petalLength"
				placeholder="Petal Length"><br /> <input type="number"
				step="0.1" name="petalWidth" placeholder="Petal Width"><br />
			<input type="submit" title="Consultar">
		</form>
		<c:if test="${not empty iris.classe }">
			<table border="1">
				<thead>
					<tr>
						<th>Atributo</th>
						<th>Valor em cm</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Sepal Length</td>
						<td><c:out value="${iris.sepalLength }" /></td>
					</tr>
					<tr>
						<td>Sepal Length</td>
						<td><c:out value="${iris.sepalWidth }" /></td>
					</tr>
					<tr>
						<td>Petal Length</td>
						<td><c:out value="${iris.petalLength }" /></td>
					</tr>
					<tr>
						<td>Petal Length</td>
						<td><c:out value="${iris.petalWidth }" /></td>
					</tr>
					<tr>
						<td>Class</td>
						<td><c:out value="${iris.classe }" /></td>
					</tr>
			</table>
		</c:if>
	</div>
</body>
</html>