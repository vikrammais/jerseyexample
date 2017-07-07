package org.chaiboy.webapp;

import org.chaiboy.webapp.dao.ClientDao;
import org.chaiboy.webapp.dao.CustomerDao;
import org.chaiboy.webapp.entity.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{param}")
    public Customer getCustomer(@HeaderParam("X-Api-Key") String token, @PathParam("param") int id) throws Exception {

        String output;
        ClientDao clientDao = new ClientDao();
        if (token == null) {
            output = "Token shouldn't be NULL";
            throw new Exception(output);
        }
        boolean verified = false;
        try {
            verified = clientDao.verifyToken(token);
        } catch (Exception e) {
            output = "Un Authorized";
            throw new Exception(output);
        }
        if (verified) {
            CustomerDao customerDao = new CustomerDao();
            Customer customer = customerDao.getCustomer(id);
            if (customer != null) {
                return customer;
            }
            else {
                output = "No Customer for this id";
                throw new Exception(output);
            }
        }
        else {
            output = "Not Authorized";
            throw new Exception(output);
        }

    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(@HeaderParam("X-Api-Key") String token, Customer customer) throws Exception {
        String output;
        ClientDao clientDao = new ClientDao();
        if (token == null) {
            output = "Token shouldn't be NULL";
            return Response.status(500).entity(output).build();
        }
        boolean verified = false;
        try {
            verified = clientDao.verifyToken(token);
        } catch (Exception e) {
            output = "Un Authorized";
            return Response.status(401).entity(output).build();
        }
        if (verified) {
            CustomerDao customerDao = new CustomerDao();
            customerDao.createCustomer(customer);
            output = "Customer Created";
            return Response.status(200).entity(output).build();
            }
        else {
            output = "Not Authorized";
            return Response.status(401).entity(output).build();
        }
    }
}