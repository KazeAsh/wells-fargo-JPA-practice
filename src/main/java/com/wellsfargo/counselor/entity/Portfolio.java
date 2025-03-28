package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @Column(nullable = false)
    @CreatedDate
    private Date create_date;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date update_date;

    protected Portfolio() {
    }

    //created constructor for Portfolio
    public Portfolio(Date create_date, Date update_date) {
        this.create_date = create_date;
        this.update_date = update_date;
    }
    //create getter and setters for each field
    public long getId() {
        return portfolioId;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    //Map Relationship: Many-to-One with Client
    @ManyToOne
    private Client client;

    //Relationship: one-to-Many with security
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_security_id", referencedColumnName = "security_id")
    private List<Security> security =  new ArrayList<Security>();


}
