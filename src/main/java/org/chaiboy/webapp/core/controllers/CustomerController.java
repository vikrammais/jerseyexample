package org.chaiboy.webapp.core.controllers;

import com.google.api.client.http.HttpStatusCodes;
import com.google.inject.Inject;
import org.chaiboy.webapp.core.factories.CustomerFactory;
import org.chaiboy.webapp.dao.CustomerDAO;
import org.chaiboy.webapp.entity.Customer;
import org.chaiboy.webapp.entity.exception.MockathonException;
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

    public CustomerInfoResponse getCustomerDetails() {
        String id = "";//
        Customer customer = null;
        try {
            customer = customerDAO.getCustomer(id);
        } catch (MockathonException e) {
            throw new MockathonException(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "ERROR_FETCHING_CUSTOMER", e);
        }
        return CustomerFactory.prepareCustomerInfoResponse(customer);
    }

}
