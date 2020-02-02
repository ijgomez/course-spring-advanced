package org.course.spring.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.course.spring.beans.Contacto;
import org.course.spring.beans.IContacto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ServicioContactos extends JdbcDaoSupport implements IServicioContactos {

	private static final long serialVersionUID = -6278461190204687138L;

	private List<IContacto> contactos = new ArrayList<IContacto>();
    
	private ConsultaContactos consultaContactos;
    
	private NuevoContacto nuevoContacto;
    
	private ActualizarContacto actContacto;
    
	

    @Override
    protected void initDao() {
        consultaContactos = new ConsultaContactos(getDataSource());
        nuevoContacto = new NuevoContacto(getDataSource());
        actContacto = new ActualizarContacto(getDataSource());
    }

    public ServicioContactos() {
    }

    @SuppressWarnings("unchecked")
    public List<IContacto> getContactos() throws DataAccessException {
        synchronized (this.contactos) {
            log.info("Cargando los contactos de la base de datos");
            contactos.clear();
            contactos.addAll(consultaContactos.execute());
            return contactos;
        }
    }

    public void insertarContacto(IContacto c) throws DataAccessException {
        nuevoContacto.insert(c);
    }

    public void actualizarContacto(IContacto c) throws DataAccessException {
        actContacto.update(c);
    }

    protected class ConsultaContactos extends MappingSqlQuery {
        protected ConsultaContactos(DataSource ds, String sql) {
            super(ds, sql);
        }

        protected ConsultaContactos(DataSource ds) {
            super(ds, 
                  "SELECT id,nombre,comentario FROM contactos ORDER BY nombre");
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
            IContacto contacto = new Contacto();
            contacto.setId(new Integer(rs.getInt("id")));
            contacto.setNombre(rs.getString("nombre"));
            contacto.setComentario(rs.getString("comentario"));
            return contacto;
        }
    }

    protected class NuevoContacto extends SqlUpdate {

        protected NuevoContacto(DataSource ds) {
            super(ds, "INSERT INTO contactos (nombre,comentario) VALUES(?,?)");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            compile();
        }

        protected void insert(IContacto contacto) {
            Object[] objs = 
                new Object[] { contacto.getNombre(), contacto.getComentario() };
            super.update(objs);
            obtenerId(contacto);
        }

        private void obtenerId(IContacto contacto) {
            contacto.setId(getJdbcTemplate().queryForObject(getIdentidad(), Integer.class));
        }

    }

    protected class ActualizarContacto extends SqlUpdate {

        protected ActualizarContacto(DataSource ds) {
            super(ds, "UPDATE contactos SET nombre=?,comentario=? WHERE id=?");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.INTEGER));
            compile();
        }

        protected int update(IContacto contacto) {
            return this.update(new Object[] { contacto.getNombre(), 
                                              contacto.getComentario(), 
                                              contacto.getId() });
        }
    }

    protected abstract String getIdentidad();
}
