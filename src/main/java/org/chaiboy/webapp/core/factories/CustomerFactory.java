package org.chaiboy.webapp.core.factories;

import org.chaiboy.webapp.entity.user.Customer;
import org.chaiboy.webapp.entity.response.CustomerInfoResponse;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerFactory {

    public static CustomerInfoResponse prepareCustomerInfoResponse(Customer customer) {
        CustomerInfoResponse customerResponse = new CustomerInfoResponse();
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setContact(customer.getContact());
        customerResponse.setCompany(customer.getCompanyId());
        customerResponse.setDateOfJoining(customer.getDateOfJoining());
        customerResponse.setLocation(customer.getLocationId());
        customerResponse.setRole(customer.getRoleId());
        customerResponse.setStatus(customer.getStatus());
        customerResponse.setAttributes();
    }
}
