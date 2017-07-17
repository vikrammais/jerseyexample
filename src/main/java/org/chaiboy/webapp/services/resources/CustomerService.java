package org.chaiboy.webapp.services.resources;

import com.google.inject.Inject;
import org.chaiboy.webapp.core.controllers.CustomerController;
import org.chaiboy.webapp.entity.exception.MockathonException;
import org.chaiboy.webapp.entity.request.CustomerInfoRequest;
import org.chaiboy.webapp.entity.response.CustomerInfoResponse;
import org.chaiboy.webapp.services.annotations.Secured;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Secured
public class CustomerService {

    private CustomerController customerController;

    @Inject
    public CustomerService(CustomerController customerController) {
        this.customerController = customerController;
    }

    @GET
    @Path("/")
    public CustomerInfoResponse getCustomer() throws MockathonException {
        return customerController.getCustomerDetails();
    }

    @PUT
    @Path("/")
    public void createCustomer(CustomerInfoRequest customerInfoRequest) throws Exception {
        customerController.createCustomerDetails(customerInfoRequest);
    }

    @POST
    @Path("/")
    public CustomerInfoResponse updateCustomer() throws Exception {
        return customerController.getCustomerDetails();
    }

    @POST
    @Path("/validate")
    public void validateCustomer() throws Exception {
        customerController.getCustomerDetails();
    }
}