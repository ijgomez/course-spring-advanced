<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>primera</title>
  </head>
  <body><p>
      Para llegar a esta p&aacute;gina, hemos reutilizado nuestro 
      <em><em><em>controladorMultiple</em></em></em>.
    </p><p>
      Mensaje desde el m&eacute;todo &quot;<em>manejarSiguiente</em>&quot; del
                                                                  controlador
                                                                  m&uacute;ltiple: <strong><c:out value="${mensaje}"/></strong>
    </p><p>
      <a href="entrada.do">
        Volvera a la p&aacute;gina anterior
      </a>
    </p></body>
</html>