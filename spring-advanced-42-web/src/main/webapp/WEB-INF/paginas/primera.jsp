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
            Primera página del asistente.
        </h1>
        <form:form commandName="comandoPersona">
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
                    <td colspan="3">
                        <input type="submit" value="Continuar"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>