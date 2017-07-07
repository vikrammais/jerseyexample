package org.chaiboy.webapp.dao;

import org.chaiboy.webapp.entity.Customer;

import java.sql.*;


/**
 * Created by Vikram Aditya on 6/23/2017.
 */
public class CustomerDao extends AbstractDAO {


    public void createCustomer(Customer customer) throws Exception {
        if( customer != null) {
            String insertCustomer = "INSERT INTO customer (name, email, phone) VALUES (?, ?, ?);";
            try {
                Connection conn = createConnection();
                PreparedStatement statement = conn.prepareStatement(insertCustomer);
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getEmail());
                statement.setString(3, customer.getPhone());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new Exception("ERROR_CREATING_CUSTOMER", e);
            }
        }
    }

    public Customer getCustomer(int id) throws Exception {
        String selectCustomer = "SELECT * FROM customer WHERE id = ?;";
        try {
            Connection conn = createConnection();
            PreparedStatement statement = conn.prepareStatement(selectCustomer);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
                Customer customer = new Customer();
                customer.setId(id);
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                return customer;
        } catch (SQLException e) {
            throw new Exception("ERROR_FETCHING_CUSTOMER", e);
        }
    }

}
