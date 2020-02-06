package org.course.spring;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.course.spring.services.ClientService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		log.info("Contexto cargado");
		
//		DataSource datasource = (DataSource) ctx.getBean("dataSource");
//		try (Connection connection = datasource.getConnection(); Statement statement = connection.createStatement();) {
//            statement.execute("CREATE TABLE personas (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(255), PRIMARY KEY (ID))");
//            connection.commit();
//        }
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	private ClientService clientService;
	
	@Before
	public void beforeTest() throws Exception {
		clientService = (ClientService) ctx.getBean("clientService");
	}

	@Test
	public void testEjecutarSpringJpa() throws Exception {
        
        final Integer MAX_ELEMENTOS = 5;
        for(int i = 0; i < MAX_ELEMENTOS; i++)
            clientService.insertarContacto(new Contact("Nombre" + System.currentTimeMillis()));
        Collection<Contact> todosContactos = clientService.getTodosLosContactos();
        log.info("se han encontrado {} contactos.",todosContactos.size());
        for (Contact contacto : todosContactos) {
            log.info("El nombre del contacto es {} y su clave es {}",contacto.getNombre(), contacto.getId());
        }
        for(int i = 0; i < MAX_ELEMENTOS; i++)
            clientService.insertarComercial(new Comercial("Nombre" + System.currentTimeMillis()));
        Collection<Comercial> todosComerciales = clientService.getTodosLosComerciales();
        log.info("se han encontrado {} comerciales.",todosComerciales.size());
        for (Comercial comercial : todosComerciales) {
            log.info("El nombre del comercial es {} y su clave es {}",comercial.getNombre(), comercial.getId());
        }
        
    }

	@Test 
	public void testEjecutarSpringJpaRelaciones() throws Exception {
        Comercial comercial = new Comercial("Comercial con contactos" + System.currentTimeMillis());
        Contact contacto = new Contact("Contact para un comercial" + System.currentTimeMillis());
        
        clientService.asignarContacto(comercial,contacto);
        
        List<Contact> contactos = clientService.getContactosDeUnComercial(comercial);
        log.info("se han encontrado {} contactos.",contactos.size());
        for (Contact elem : contactos) {
            log.info("El nombre del contacto es {} y su clave es {}.",elem.getNombre(), elem.getId());
        }
    }

	
	
}
