<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=windows-1252"/>
        <title>primera</title>
        <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    </head>
    <body><h1>
            P&aacute;gina de login.
        </h1>
        <ul>
            <li>
                <h3>
                    Introducir&nbsp;&quot;curso&quot;&nbsp;y&nbsp;&quot;curso&quot;&nbsp;para&nbsp;entrar.&nbsp;
                </h3>
            </li>
            <li>
                <h3>
                    Probar&nbsp;con&nbsp;otros&nbsp;valores&nbsp;para&nbsp;ver&nbsp;la&nbsp;respuesta&nbsp;del&nbsp;programa.
                </h3>
            </li>
        </ul>
        <p>
            <form:form commandName="login">
                <table>
                    <tr>
                        <td>Nombre de usuario:</td>
                        <td>
                            <form:input path="nombre"/>
                        </td>
                        <td>
                            <form:errors path="nombre"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Clave de acceso:</td>
                        <td>
                            <form:password path="clave"/>
                        </td>
                        <td>
                            <form:errors path="clave"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="Continuar"/>
                        </td>
                    </tr>
                </table>
            </form:form>

            <a href="siguiente.do">
                Volver a la p&aacute;gina anterior
            </a>
        </p>
    </body>
</html>