<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SpringWeb0012</title>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.2.3/dijit/themes/soria/soria.css";
        </style>

        <style type="text/css">
            #centradovh {
                position: absolute;
                left: 50%;
                top: 50%;
                width: 350px;
                height: 350px;
                margin-top: -150px;
                margin-left: -150px;
                overflow: auto;
            }
            body,html {
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
            }

            #cargando {
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
                background: #fff
                url('http://o.aolcdn.com/dojo/1.2.3/dojox/image/resources/images/loading.gif')
                no-repeat center center;
                position: absolute;
                z-index: 999;
            }

            #principal {
                width: 100%;
                height: 100%;
            }
        </style>

        <script src="http://o.aolcdn.com/dojo/1.2.3/dojo/dojo.xd.js"></script>

        <script type="text/javascript">
            var ocultarCargador = function() {
                dojo.fadeOut( {
                    node :"cargando",
                    duration :900,
                    onEnd : function() {
                        dojo.style("cargando", "display", "none");
                    }
                }).play();
            }

            var mostrarLogin = function() {
                dojo.xhrGet( {
                    url :"login.do",
                    handleAs :"text",
                    timeout :5000,
                    load : function(data, ioArgs) {
                        dojo.parser.parse();
                        dijit.byId("principal").attr('content', data);
                        ocultarCargador();
                        return data;
                    },
                    error : function(error, ioArgs) {
                        console.warn("¡error!", error);
                    }
                });
            }

            dojo.addOnLoad( function() {

                dojo.require("dijit.dijit"); // cargar la capa digit para optimizar un poco
                dojo.require("dijit.layout.ContentPane");
                dojo.require("dijit.TitlePane");
                dojo.require("dijit.form.Button");
                dojo.require("dijit.form.TextBox");

                // notice the second onLoad here:
                dojo.addOnLoad( function() {
                    mostrarLogin();
                });

            });
        </script>


    </head>
    <body class="soria">
        <div id="cargando"></div>
        <div dojotype="dijit.layout.ContentPane" id="principal"></div>
    </body>
</html>
