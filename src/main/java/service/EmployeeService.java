package service;

import businessLogic.Util;
import dao.EmployeeDao;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public class EmployeeService extends Util implements EmployeeDao {

    private Connection connection = getConnection();

    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO employee (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setLong(5, employee.getAdressId());

            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<Employee>();

        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setBirthday(resultSet.getDate("BIRTHDAY"));
                employee.setAdressId(resultSet.getLong("ADDRESS_ID"));

                employeeList.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return employeeList;
    }

    public Employee getById(Long id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Employee employee) {

    }

    public void delete(Employee employee) {

    }
}
