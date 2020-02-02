package org.course.spring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.course.spring.beans.Persona;
import org.course.spring.beans.PersonaImpl;
import org.course.spring.exceptions.PersonaException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PersonaDaoImpl extends JdbcDaoSupport implements PersonaDao {

	@Override
	public Integer contarPersonas() throws DataAccessException {
		return getJdbcTemplate().queryForObject("select count(*) from personas", Integer.class);
	}

	@Override
	public Integer contarPersonasUsandoParametros(String nombre) throws DataAccessException {
		return getJdbcTemplate().queryForObject("select count(*) from personas where nombre like ?", new Object[] { "%" + nombre + "%" }, Integer.class);
	}

	@Override
	public Persona encontrarPersona(Integer id) throws DataAccessException {
		Persona persona = (Persona) getJdbcTemplate().queryForObject("select * from personas where id = ?", new Object[] { id }, new PersonaRowMapper());
		return persona;
	}

	@Override
	public Collection<Persona> encontrarTodos() throws DataAccessException {
		return getJdbcTemplate().query("select * from personas", new PersonaRowMapper());
	}

	@Override
	public void insertarPersona(Persona persona) throws DataAccessException, PersonaException {
		getJdbcTemplate().update("insert into personas (nombre) values (?)", new Object[] { persona.getNombre() });
	}

	@Override
	public void actualizarPersona(Persona persona) throws DataAccessException {
		getJdbcTemplate().update("update personas set nombre = ? where id = ?", new Object[] { persona.getNombre(), persona.getId() });
	}

	@Override
	public void borrarPersona(Persona persona) throws DataAccessException {
		getJdbcTemplate().update("delete from personas where id = ?", new Object[] { persona.getId() });
	}

	@Override
	public Integer insertarPersonaDevolviendoLaClavePrimaria(final Persona persona) throws DataAccessException {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("insert into personas (nombre) values (?)", new String[] { "id" });
				ps.setString(1, persona.getNombre());
				return ps;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	private static final class PersonaRowMapper implements RowMapper<Persona> {

		@Override
		public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
			PersonaImpl persona = new PersonaImpl();
			persona.setId(resultSet.getInt("id"));
			persona.setNombre(resultSet.getString("nombre"));
			return persona;
		}
	}
}
