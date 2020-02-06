<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>primera</title>
  </head>
  <body><p>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </p><p>
      Tercer ejemplo de una aplicaci&oacute;n Web hecha con Spring 2.0.
    </p><p>
      Hemos hecho lo siguiente:
    </p><ul>
      <li>
        <p>
          <strong>configurar</strong>
           la aplicaci&oacute;n para que soporte 
          <em>logging</em>
        </p>
      </li>
      <li>
        <p>
          <strong>pasar a la servlet de Spring</strong>
           (DispatcherServlet) todas las peticiones de p&aacute;ginas que acaben
          con el sufijo 
          <em>do</em>. Obs&eacute;rvese que estamos usando p&aacute;ginas
                     l&oacute;gicas enlazadas a p&aacute;ginas f&iacute;sicas<em><em>&nbsp;</em></em>
        </p>
      </li>
      <li>
        <p>
          <strong>informar a Spring </strong>de d&oacute;nde se encuentran
                                             nuestras
                                             p&aacute;ginas&nbsp;f&iacute;sicas
                                             (p&aacute;ginas JSP simples)
                                             mediante un 
          <em>InternalResourceViewResolver</em>
        </p>
      </li>
      <li>
        <p>
          <strong>asociar peticiones de p&aacute;ginas</strong>
           con controladores, mediante un 
          <em>BeanNameUrlHandlerMapping</em>
        </p>
      </li>
      <li>
        <p>
          <strong>definir un controlador</strong>, 
          <em>EntradaController</em>, responsable de devolver la vista asociada
                                    a la petici&oacute;n l&oacute;gica &quot;<em>/entrada.do</em>&quot;,
                                                                                                 as&iacute;
                                                                                                 como
                                                                                                 los
                                                                                                 datos
                                                                                                 relevantes
                                                                                                 para
                                                                                                 ella,
                                                                                                 si
                                                                                                 existen.
                                                                                                 Es
                                                                                                 decir,
                                                                                                 el
                                                                                                 controlador
                                                                                                 se
                                                                                                 ocupa
                                                                                                 de
                                                                                                 proporcionar
                                                                                                 la
                                                                                                 vista
                                                                                                 siguiente
                                                                                                 convenientemente
                                                                                                 rellena
                                                                                                 de
                                                                                                 los
                                                                                                 datos
                                                                                                 que
                                                                                                 necesita
        </p>
      </li>
    </ul><p>
      Mensaje desde el controlador:<strong>
         
        <c:out value="${mensaje}"/></strong>
    </p><p>
      <a href="siguiente.do">
        Pincha aqu&iacute; para ir a la p&aacute;gina siguiente
      </a>
    </p></body>
</html>