package org.chaiboy.webapp.entity;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="WalletTransactions")
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private user.Customer fromCustomerId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private user.Customer toCustomerId;

    private int type;

    private String reference;

    private String source;

    private String destination;

    public WalletTransactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user.Customer getFromCustomerId() {
        return fromCustomerId;
    }

    public void setFromCustomerId(user.Customer fromCustomerId) {
        this.fromCustomerId = fromCustomerId;
    }

    public user.Customer getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(user.Customer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
