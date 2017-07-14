package org.chaiboy.webapp.services.resources;

import com.google.inject.Inject;
import org.chaiboy.webapp.core.controllers.CustomerController;
import org.chaiboy.webapp.dao.ClientDao;
import org.chaiboy.webapp.dao.CustomerDAO;
import org.chaiboy.webapp.entity.Customer;
import org.chaiboy.webapp.entity.response.CustomerInfoResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {

    private CustomerController customerController;

    @Inject
    public CustomerService(CustomerController customerController) {
        this.customerController = customerController;
    }

    @GET
    @Path("/") //@HeaderParam("X-Api-Key") String token,@PathParam("param") int id
    public CustomerInfoResponse getCustomer() throws Exception {
        return customerController.getCustomerDetails();
    }

    @PUT
    @Path("/")
    public Response createCustomer(Customer customer) throws Exception {
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
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.createCustomer(customer);
            output = "Customer Created";
            return Response.status(200).entity(output).build();
            }
        else {
            output = "Not Authorized";
            return Response.status(401).entity(output).build();
        }
    }

    @POST
    @Path("/")
    public CustomerInfoResponse updateCustomer() throws Exception {
        return customerController.getCustomerDetails();
    }

    @POST
    @Path("/validate")
    public void validateCustomer() throws Exception {
        return customerController.getCustomerDetails();
    }
}