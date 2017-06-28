package dao;

import entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface EmplProjDao {

    void add(EmplProj emplProj) throws SQLException;

    List<EmplProj> getAll() throws SQLException;

    EmplProj getByEmplIdAndProjId(Long employeeeId, Long projectId) throws SQLException;

    void update(EmplProj emplProj) throws SQLException;

    void delete(EmplProj emplProj) throws SQLException;


}
