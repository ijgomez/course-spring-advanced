package org.course.spring.services

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.course.spring.beans.Usuario
import org.course.spring.beans.Rol

@Repository
@Transactional(readOnly = true)
@Service("ejemploServicio")
class ExerciseService {
    
	@PersistenceContext
    EntityManager em;

    @Transient
    def crearUsuario() {
        new Usuario(nombre: "abc" + System.currentTimeMillis())
    }

    @Transient
    def crearRol() {
        new Rol(nombre: "xyz" + System.currentTimeMillis())
    }

    def asignarRol(usuario, rol) {
        usuario.roles.add rol
        rol.usuario = usuario
    }
    
    def getUsuarios() {
        def lista = []
        lista.addAll em.createQuery("select distinct u from Usuario as u join fetch u.roles").resultList
        lista
    }

    @Transactional(readOnly = false)
    def guardarUsuario(usuario) {
        em.persist usuario
        usuario.id
    }

    def localizarUsuario(clave) {
        em.find Usuario.class, clave
    }

    def autenticar(usuario) {
        def q = em.createQuery("select u from Usuario u where u.nombre = :nombre")
        q.setParameter "nombre", usuario.getNombre()
        try {
            q.singleResult
        } catch (NoResultException e) {
            println e
            null
        } catch (NonUniqueResultException e) {
            println e
            null
        }
    }
}

