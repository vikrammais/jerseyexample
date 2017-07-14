package org.chaiboy.webapp.entity.response;

import com.google.api.client.util.DateTime;
import org.chaiboy.webapp.entity.Attribute;

import java.util.List;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerInfoResponse extends BaseResponse {
    private String firstName;
    private String lastName;
    private String contact;
    private DateTime dateOfJoining;
    private String email;
    private String role;
    private String location;
    private String company;
    private String status;
    private List<Attribute> attributes;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public DateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(DateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
