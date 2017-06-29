package service;

import businessLogic.Util;
import dao.ProjectDao;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 28.06.2017.
 */
public class ProjectService extends Util implements ProjectDao {

    private Connection connection = getConnection();

    public void add(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO project (ID, TITLE) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

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

    public List<Project> getAll() throws SQLException {
        List<Project> listProject = new ArrayList<Project>();

        Statement statement = null;

        String sql = "SELECT ID, TITLE FROM project";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                listProject.add(project);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return listProject;
    }

    public Project getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM project WHERE ID=?";
        Project project = new Project();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return project;
    }

    public void update(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE project SET ID=?, TITLE=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

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

    public void delete(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM project WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, project.getId());

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
