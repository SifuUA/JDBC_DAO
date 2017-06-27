package dao;

import entity.Project;

import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface ProjectDao {

    void add(Project project);

    List<Project> getAll();

    Project getById(Long id);

    void update(Project project);

    void delete(Project project);
}
