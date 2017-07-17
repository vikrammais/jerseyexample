package org.chaiboy.webapp.entity.user;

import com.google.api.client.util.DateTime;

import javax.persistence.*;

/**
 * Created by Vikram Aditya on 6/23/2017.
 */
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String firstName;
    private String lastName;
    private String contact;
    private DateTime dateOfJoining;
    private String email;
    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id", nullable = false)
    private Location location;
    private String password;
    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    private Company company;
    private String status;
    private int balance;

    public Customer() {
    }


}
