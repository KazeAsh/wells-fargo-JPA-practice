package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    protected Client() {
        this("", "", "", "", "");
    }


    //made a constructor for Client
    public Client(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //create getter and setters for each field
    public long getClientId() {
        return clientId;
    }

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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Mapping back Relationship: Many-To-One with Advisor
    @ManyToOne
    private Advisor advisor;

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    //Create Relationship: One-to-Many with Portfolio
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_profile_id", referencedColumnName = "profile_id")
    private List<Portfolio> portfolio;

}
