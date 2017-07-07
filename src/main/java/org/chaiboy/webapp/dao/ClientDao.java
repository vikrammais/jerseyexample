package org.chaiboy.webapp.dao;

import org.chaiboy.webapp.entity.Client;
import org.chaiboy.webapp.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Vikram Aditya on 6/23/2017.
 */
public class ClientDao extends AbstractDAO {

    public void createClient(Client client) throws Exception {
        if( client != null) {
            String insertClient = "INSERT INTO client (email, password) VALUES (?, ?);";
            try {
                Connection conn = createConnection();
                PreparedStatement statement = conn.prepareStatement(insertClient);
                statement.setString(1, client.getEmail());
                statement.setString(2, client.getPassword());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new Exception("ERROR_CREATING_CLIENT", e);
            }
        }
    }

    public void createToken(String token) throws Exception {
        String insertToken = "INSERT INTO token (token) VALUES (?);";
        try {
            Connection conn = createConnection();
            PreparedStatement statement = conn.prepareStatement(insertToken);
            statement.setString(1, token);
            System.out.println("Token : "+token);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new Exception("ERROR_STORING_TOKEN", e);
        }
    }

    public boolean verifyToken(String token) throws Exception {
        String insertToken = "SELECT * FROM token WHERE token = (?);";
        try {
            boolean flag = false;
            Connection conn = createConnection();
            PreparedStatement statement = conn.prepareStatement(insertToken);
            statement.setString(1, token);
            System.out.println("Token : "+token);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String result = resultSet.getString("token");
            if (result != null) {
                flag = true;
            }
//            String result = resultSet.getString("token");
//            if (result != null) {
//            }
            return flag;
        } catch (SQLException e) {
            throw new Exception("INVALID_TOKEN", e);
        }
    }


    public Client getClient(String email) throws Exception {
        String selectClient = "SELECT * FROM client WHERE email = (?);";
        try {
            Connection conn = createConnection();
            PreparedStatement statement = conn.prepareStatement(selectClient);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Client client = new Client();
            client.setEmail(resultSet.getString("email"));
            client.setPassword(resultSet.getString("password"));
            return client;
        } catch (SQLException e) {
            throw new Exception("ERROR_FETCHING_CUSTOMER", e);
        }
    }


}
