<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Página controlada por Spring número uno. Ejemplo SpringWeb0010</h1>
        
        <h3>Subir un archivo al servidor</h3>
        <form method="post" action="subirArchivo.form" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit" value="Enviar Archivo"/>
        </form>        
    </body>
</html>
