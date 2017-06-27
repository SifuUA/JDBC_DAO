package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public interface AddressDao {

    //creat
    void add(Address address) throws SQLException;

    //read
    //get all Address from DB
    List<Address> getAll() throws SQLException;

    //get Address from DB by ID
    Address getById(Long id);

    //update
    void update(Address address);

    //delete
    void remove(Address address);
}
