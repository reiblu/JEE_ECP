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
        Alta de <b>Tema</b>
    </h2>
    <c:set var="tema" scope="request" value="${altaTema}" />
    <form action="/jee/jsp/altaTema" method="post">
        <p>
            Crea un tema nuevo: <br> 
            	Nombre: <input type="text" name="tema"/> <br>
            	Pregunta: <input type="text" name="pregunta"/> <br>
        </p>
        <p>
			<input type="submit" value="Crear tema" />
		</p>
    </form>

</body>
</html>