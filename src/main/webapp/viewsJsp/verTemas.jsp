<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver temas</title>
</head>
<body>

    <h2>
        Vista de <b>Temas</b>
    </h2>
    <c:set var="temaBean" scope="request" value="${verTemas}" />
    <div>${temaBean.update()}</div>
    <form action="/jee/jsp/votar" method="post">
        <p>
            Temas: <select name="tema">
                <c:forEach var="tema" items="${temaBean.temas}">
                    <option value="${tema.id}">${tema.nombre}</option>
                </c:forEach>
            </select>
        </p>
        <p>
			<input type="submit" value="Seleccionar" />
		</p>
    </form>

</body>
</html>