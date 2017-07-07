package org.chaiboy.webapp;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import org.chaiboy.webapp.dao.ClientDao;
import org.chaiboy.webapp.entity.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;


/**
 * Created by Vikram Aditya on 6/23/2017.
 */
@Path("/client")
public class ClientService {

    @POST
    @Path("/test")
    public Response test(@QueryParam("email") String email, @QueryParam("password") String password) throws SQLException {
        String out = "df";
        String url = "jdbc:mysql://localhost:3306/lexxington";
        Connection conn = DriverManager.getConnection(url, "root", "sherlock");
        String insertClient = "INSERT INTO client (email, password) VALUES (?, ?);";
        PreparedStatement statement = conn.prepareStatement(insertClient);
        Client client = new Client();
        client.setEmail(email);
        client.setPassword(password);
        System.out.println("Email : "+email+", Password : "+password);
        statement.setString(1, email);
        statement.setString(2, password);
        statement.executeUpdate();
        statement.close();
        return Response.status(200).entity(out).build();
    }

    @POST
    @Path("/register")
    public Response registerClient(@QueryParam("email") String email, @QueryParam("password") String password) throws NoSuchAlgorithmException {
        String out = "success";
        try{
            byte[] encoded = Base64.encodeBase64(password.getBytes());
            String encryptedPassword = new String(encoded);
            Client client = new Client();
            client.setEmail(email);
            client.setPassword(encryptedPassword);
            ClientDao clientDao = new ClientDao();
            System.out.println(client.getEmail()+","+client.getPassword());
            clientDao.createClient(client);
            return Response.status(200).entity(out).build();
        }
        catch (NoSuchAlgorithmException E) {
            return Response.status(500).entity("pungi").build();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return Response.status(500).entity("fail").build();
        }
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/authenticate")
    public String authenticateClient(@QueryParam("email") String email, @QueryParam("password") String password) throws NoSuchAlgorithmException {
        String out = "success";
        try{
            byte[] encoded = Base64.encodeBase64(password.getBytes());
            String encryptedPassword = new String(encoded);
            ClientDao clientDao = new ClientDao();
            Client client = clientDao.getClient(email);
            System.out.println("Encrypted : "+encryptedPassword);
            System.out.println("DB : "+client.getPassword());
            String token;
            if (client.getPassword().equals(encryptedPassword)) {
                token = UUID.randomUUID().toString();
                clientDao.createToken(token);
            }
            else {
                token = "Credentils are Wrong";
            }
            return token;
        }
        catch (NoSuchAlgorithmException E) {
            return "Error";
        } catch (Exception e) {
            e.printStackTrace();
            return "sql fail";
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/verify")
    public String verify(@HeaderParam("X-Api-Key") String token) throws Exception {
        ClientDao clientDao = new ClientDao();
        boolean verified = clientDao.verifyToken(token);
        if (verified) {
            return "Success";
        }
        else {
            return "failure";
        }
    }

}
