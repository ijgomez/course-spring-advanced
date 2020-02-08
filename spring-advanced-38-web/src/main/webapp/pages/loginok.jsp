<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>primera</title>
        <link href="${pageContext.request.contextPath}/css/oracle.css" rel="stylesheet" media="screen"/>
    </head>
    <body><p>
            <c:if test="${!empty errorLogin}">
                <h4>
                    <c:out value="${errorLogin}"/>
                </h4>
                <h4>
                    <c:out value="${sugerencia}"/>
                </h4>
                <p>
                    <a href="login.form">
                        Reintentar
                    </a>
                </p>
            </c:if>
        </p>
        <p>
            <c:if test="${empty errorLogin}">
                <h2>
                    Su nombre de usuario es
                    <strong><c:out value="${nombre}"/></strong>
                </h2>
                <h2>
                    Su clave de acceso es
                    <strong><c:out value="${clave}"/></strong>
                </h2>
            </c:if>
        </p>
        <p>
            <a href="entrada.do">
                Volver a la p&aacute;gina de entrada
            </a>
        </p>
    </body>
</html>