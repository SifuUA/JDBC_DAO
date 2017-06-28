package service;

import dao.ProjectDao;
import entity.Project;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Alex on 28.06.2017.
 */
public class ProjectService extends Project implements ProjectDao {

    Connection connection = null;

    public void add(Project project) {

    }

    public List<Project> getAll() {
        return null;
    }

    public Project getById(Long id) {
        return null;
    }

    public void update(Project project) {

    }

    public void delete(Project project) {

    }
}
