<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>primera</title>
    <link href="css/blaf.css" rel="stylesheet" media="screen"/>
  </head>
  <body><p>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </p><h1>
      Para llegar a esta p&aacute;gina, hemos reutilizado nuestro 
      <em><em><em>controladorMultiple</em></em></em>
      .
    </h1><h3>
      El enlace &quot;Ir a la p&aacute;gina siguiente&quot; lleva a un
      formulario gestionado &uacute;nicamente con Spring.
    </h3><p>
      Los objetos involucrados son:
    </p><ul>
      <li>
        <p>
          <strong>un &quot;<em>LoginFormController</em>&quot;</strong>, que decide
                                                             cu&aacute;l ser&aacute;
                                                             la vista siguiente,
                                                             apoy&aacute;ndose en
        </p>
      </li>
      <li>
        <p>
          <strong>un &quot;<em>comando</em>&quot;</strong>
           llamado &quot;<em>Login</em>&quot;, al cual Spring transfiere los
                                       datos del formularios, los cuales
                                       previamente
        </p>
      </li>
      <li>
        <p>
          <strong>han sido validados</strong>
           por un &quot;<em>LoginValidator</em>&quot;
        </p>
      </li>
    </ul><p>
      Mensaje desde el m&eacute;todo &quot;<em>manejarSiguiente</em>&quot; del
                                                                    controlador
                                                                    m&uacute;ltiple: 
      <strong><c:out value="${mensaje}"/></strong>
    </p><p>
      <a href="entrada.do">
        Volvera a la p&aacute;gina anterior
      </a>
    </p><p>
      <a href="login.form">
        Ir a la p&aacute;gina siguiente
      </a>
    </p><p>
      &nbsp;
    </p><p>
      &nbsp;
    </p></body>
</html>