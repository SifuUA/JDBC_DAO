package service;

import businessLogic.Util;
import dao.AddressDao;
import entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 27.06.2017.
 */
public class AddressService extends Util implements AddressDao{

    Connection connection = getConnection();

    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ADDRESS(ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }

    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<Address>();

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE";

        Statement statement = null;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next())
        {

        }
        return null;
    }

    public Address getById(Long id) {
        return null;
    }

    public void update(Address address) {

    }

    public void remove(Address address) {

    }
}
