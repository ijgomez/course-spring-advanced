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
      Para llegar a esta p&aacute;gina, hemos creado un nuevo controlador (<em>SiguienteController</em>)
                                                                                                       y
                                                                                                       empleado
                                                                                                       un
                                                                                                       mapeador
                                                                                                       distinto,
                                                                                                       llamado 
      <em>SimpleUrlHandlerMapping.</em>
    </p><p>
      En la misma aplicaci&oacute;n, pueden coexistir mapeadores distintos.
    </p><p>
      Cada p&aacute;gina ha&nbsp;de llevar asociado su propio controlador,
      aunque tambi&eacute;n existe&nbsp;un controlador predefinido (<em>MultiActionController</em>),
                                                                                                  que
                                                                                                  puede
                                                                                                  ser
                                                                                                  compartido
                                                                                                  por
                                                                                                  varias
                                                                                                  p&aacute;ginas.
    </p><p>
      Mensaje del nuevo controlador:<strong>
         
        <c:out value="${mensaje}"/></strong>
    </p><p>
      <a href="entrada.do">
        Volvera a la p&aacute;gina anterior
      </a>
    </p></body>
</html>