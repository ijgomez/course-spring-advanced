/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.course.spring.beans.Persona;
import org.course.spring.beans.PersonaImpl;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 *
 * @author Administrador
 */
public class PersonaDaoImpl implements PersonaDao {

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private SimpleJdbcInsert insertarPersona;

    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);

        insertarPersona = new SimpleJdbcInsert(dataSource).withTableName("personas").usingGeneratedKeyColumns("id");
    }

    public Persona buscarPersona(Integer id) {
        final String sql = "select id, nombre from personas where id = ?";

        ParameterizedRowMapper<Persona> mapper = new ParameterizedRowMapper<Persona>() {

            public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
                Persona persona = new PersonaImpl();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                return persona;
            }
        };

        return simpleJdbcTemplate.queryForObject(sql, mapper, id);
    }

    public Integer insertarPersonaDevolviendoLaClave(Persona persona) {
        Number nuevaClave = insertarPersona.executeAndReturnKey(
                personaParameterSource(persona));
        persona.setId(nuevaClave.intValue());
        return persona.getId();
    }

    private MapSqlParameterSource personaParameterSource(Persona persona) {
        return new MapSqlParameterSource().addValue("id", persona.getId()).addValue("nombre", persona.getNombre());
    }

    public void insertarPersona(Persona persona) {
        Map m = Collections.singletonMap("nombre", persona.getNombre());
        insertarPersona.execute(m);
    }

    public List todas() {
        final String sql = "select * from personas";
        return simpleJdbcTemplate.queryForList(sql);
    }
}
