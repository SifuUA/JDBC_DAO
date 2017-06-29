package dao;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface ProjectDao {

    void add(Project project) throws SQLException;

    List<Project> getAll() throws SQLException;

    Project getById(Long id) throws SQLException;

    void update(Project project) throws SQLException;

    void delete(Project project) throws SQLException;
}
