package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    @Value("${employee.select}")
    private String selectSql;

    @Value("${employee.findById}")
    private String findByIdSql;

    @Value("${employee.create}")
    private String createSql;

    @Value("${employee.update}")
    private String updateSql;

    @Value("${employee.delete}")
    private String deleteSql;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Employee.class);

    public EmployeeDao(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query(selectSql, rowMapper);
    }

    public Optional<Employee> findById(Long employeeId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("EMPLOYEE_ID", employeeId);
        List<Employee> results = namedParameterJdbcTemplate.query(findByIdSql, sqlParameterSource, rowMapper);
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }


    public Long createEmployee(Employee employee) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("FIRST_NAME", employee.getFirstName())
                .addValue("LAST_NAME", employee.getLastName())
                .addValue("DEPARTMENT_ID", employee.getDepartment_id())
                .addValue("JOB_TITLE", employee.getJob_title())
                .addValue("GENDER", employee.getGender().toString())
                .addValue("DATE_OF_BIRTH", employee.getDate_of_birth());
        return Long.valueOf(namedParameterJdbcTemplate.update(createSql, sqlParameterSource));
    }

    public Long updateEmployee(Employee employee) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("FIRST_NAME", employee.getFirstName())
                .addValue("LAST_NAME", employee.getLastName())
                .addValue("DEPARTMENT_ID", employee.getDepartment_id())
                .addValue("JOB_TITLE", employee.getJob_title())
                .addValue("GENDER", employee.getGender().toString())
                .addValue("DATE_OF_BIRTH", employee.getDate_of_birth())
                .addValue("EMPLOYEE_ID", employee.getEmployeeId());
        return Long.valueOf(namedParameterJdbcTemplate.update(updateSql, sqlParameterSource));
    }

    public Long delete(Long employeeId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("EMPLOYEE_ID", employeeId);
        return Long.valueOf(namedParameterJdbcTemplate.update(deleteSql, sqlParameterSource));
    }


}
