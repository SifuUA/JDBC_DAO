package service;

import businessLogic.Util;
import dao.EmplProjDao;
import dao.EmployeeDao;
import entity.EmplProj;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 28.06.2017.
 */
public class EmplProjService extends Util implements EmplProjDao {

    private Connection connection = getConnection();

    public void add(EmplProj emplProj) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

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

    public List<EmplProj> getAll() throws SQLException {

        List<EmplProj> listEmplProjs = new ArrayList<EmplProj>();

        Statement statement = null;

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM empl_proj";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                listEmplProjs.add(emplProj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return listEmplProjs;
    }

    public EmplProj getByEmplIdAndProjId(Long employeeeId, Long projectId) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM empl_proj WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
        EmplProj emplProj = new EmplProj();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employeeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return emplProj;
    }

    public void update(EmplProj emplProj) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE empl_proj SET EMPLOYEE_ID=?, PROJECT_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getProjectId());
            preparedStatement.setLong(2, emplProj.getEmployeeId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }

    public void delete(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM empl_proj WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }
}
