package org.chaiboy.webapp.core.controllers;

import com.google.api.client.http.HttpStatusCodes;
import com.google.inject.Inject;
import org.chaiboy.webapp.core.factories.CustomerFactory;
import org.chaiboy.webapp.dao.CustomerDAO;
import org.chaiboy.webapp.entity.user.Customer;
import org.chaiboy.webapp.entity.exception.MockathonException;
import org.chaiboy.webapp.entity.request.CustomerInfoRequest;
import org.chaiboy.webapp.entity.response.CustomerInfoResponse;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerController {

    private CustomerDAO customerDAO;

    @Inject
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerInfoResponse getCustomerDetails() throws MockathonException {
        String id = "";//get from session
        Customer customer = null;
        try {
            customer = customerDAO.getCustomer(id);
        } catch (Exception e) {
            throw new MockathonException(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "ERROR_FETCHING_CUSTOMER", e);
        }
        return CustomerFactory.prepareCustomerInfoResponse(customer);
    }

    public void createCustomerDetails(CustomerInfoRequest customerInfoRequest) throws MockathonException {
        //CustomerInfoRequest - additinal data
        String output;
        try {
             customerDAO.createCustomer(null);
        } catch (Exception e) {
            throw new MockathonException(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "ERROR_CREATING_CUSTOMER", e);
        }
    }



}
