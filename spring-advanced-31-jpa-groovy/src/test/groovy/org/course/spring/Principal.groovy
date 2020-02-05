package org.course.spring

import org.springframework.context.support.ClassPathXmlApplicationContext;

class Principal {
    def ctx;
    def ejemploServicio;
    def clave;

    /**
     * @param args the command line arguments
     */
    static void main(args) {
        Principal m = new Principal()
        m.initSpring()
        m.testUsuariosRoles()
        m.testTodosLosUsuarios()
        m.testAutenticar()
        m.testLocalizarUsuario()
    }

    def initSpring() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml")
        ejemploServicio = ctx.getBean("ejemploServicio")
        println 'Contexto cargado'
        println "Servicio ${ctx} encontrado"
    }

    def testAutenticar() {
        def u = ejemploServicio.crearUsuario()
        u.nombre = 'NombreUsuario6'
        println ejemploServicio.autenticar(u) ? 'Autenticado' : 'No autenticado'
    }

    def testLocalizarUsuario() {
        println "Buscando al usuario con Id $clave"
        def usuario = ejemploServicio.localizarUsuario(clave)
        println "Usuario encontrado"
    }

    def testTodosLosUsuarios() {
        println "Mostrando a todos los usuarios registrados..."
         ejemploServicio.usuarios.each{
            println it
            println "Este usuario tiene asignados ${it.roles.size()} roles"
            it.roles.each{ rol ->
                println "\t" + rol
            }
        }
    }

    def testUsuariosRoles() {
        def usuario = ejemploServicio.crearUsuario()
        def r1 =  ejemploServicio.crearRol()
        def r2 =  ejemploServicio.crearRol()
        ejemploServicio.asignarRol usuario, r1
        ejemploServicio.asignarRol usuario, r2
        clave = ejemploServicio.guardarUsuario(usuario)
        println "Usuario con clave $clave guardado"
    }
}

