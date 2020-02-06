<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h1>Página controlada por Spring número 2. Ejemplo SpringWeb0010</h1>
        <c:if test="${info.longitud == 0}">
            <h3>No se ha detectado ningún archivo</h3>
        </c:if>
        <c:if test="${info.longitud != 0}">
            <h3>Se ha detectado un archivo llamado ${info.nombre} con una longitud de ${info.longitud} bytes</h3>
        </c:if>
        <h3>Lista de archivos</h3>
        <c:forEach var="archivo" items="${info.archivos}">
            ${archivo}<br>
        </c:forEach>
        <a href="index.jsp">Pinche aquí para ir a la primera página</a>
    </body>
</html>
