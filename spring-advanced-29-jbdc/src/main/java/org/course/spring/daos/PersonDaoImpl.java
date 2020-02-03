package org.course.spring.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.course.spring.beans.Person;
import org.course.spring.beans.PersonImpl;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class PersonDaoImpl implements PersonDao {

    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private SimpleJdbcInsert insertarPersona;

    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);

        insertarPersona = new SimpleJdbcInsert(dataSource).withTableName("personas").usingGeneratedKeyColumns("id");
    }

    public Person buscarPersona(Integer id) {
        final String sql = "select id, nombre from personas where id = ?";

        ParameterizedRowMapper<Person> mapper = new ParameterizedRowMapper<Person>() {

            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new PersonImpl();
                person.setId(rs.getInt("id"));
                person.setNombre(rs.getString("nombre"));
                return person;
            }
        };

        return simpleJdbcTemplate.queryForObject(sql, mapper, id);
    }

    public Integer insertarPersonaDevolviendoLaClave(Person person) {
        Number nuevaClave = insertarPersona.executeAndReturnKey(
                personaParameterSource(person));
        person.setId(nuevaClave.intValue());
        return person.getId();
    }

    private MapSqlParameterSource personaParameterSource(Person person) {
        return new MapSqlParameterSource().addValue("id", person.getId()).addValue("nombre", person.getNombre());
    }

    public void insertarPersona(Person person) {
        Map<String, Object> m = Collections.singletonMap("nombre", person.getNombre());
        insertarPersona.execute(m);
    }

    public List<Map<String, Object>> todas() {
        final String sql = "select * from personas";
        return simpleJdbcTemplate.queryForList(sql);
    }
}
