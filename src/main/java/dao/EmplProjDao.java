package dao;

import entity.EmplProj;

import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface EmplProjDao {

    void add(EmplProj emplProj);

    List<EmplProj> getAll();

    EmplProj getVyEmplIdAndProjId(Long employeeeId, Long projectId);

    void update(EmplProj emplProj);

    void delete(EmplProj emplProj);


}
