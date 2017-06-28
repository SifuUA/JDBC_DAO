package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface EmployeeDao {

    void add(Employee employee) throws SQLException;

    List<Employee> getAll() throws SQLException;

    Employee getById(Long id) throws SQLException;

    void update(Employee employee) throws SQLException;

    void delete(Employee employee) throws SQLException;
}
