<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar</title>
</head>
<body>

	<h2>
		Vista de <b>Votos</b>
	</h2>
	<c:set var="votos" scope="request" value="${verVotos}" />
	<div>${votos.update()}</div>
	<p>
		Tema seleccionado: <br> Nombre: ${votos.tema.nombre} <br>
		Pregunta: ${votos.tema.pregunta} <br> Numero de votos:
		${votos.numVotos} <br> Media de votos por nivel escogido:
		${votos.mediaValoracion}

	</p>

</body>
</html>