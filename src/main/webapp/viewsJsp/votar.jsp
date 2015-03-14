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
    <c:set var="votar" scope="request" value="${votar}" />
    <div>${votar.update()}</div>
    <form action="/jee/jsp/votar" method="post">
        <p>
            Tema seleccionado: <br> 
            	Nombre: ${votar.tema.nombre} <br>
            	Pregunta: ${votar.tema.pregunta} <br>
        </p>
        <p>
			<input type="submit" value="votar" />
		</p>
    </form>

</body>
</html>