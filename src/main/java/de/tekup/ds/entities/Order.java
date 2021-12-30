package de.tekup.ds.entities;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}

enum OrderStatus{
    CREATE,
    SHIPPING,
    DELIVERED,
    PAID
}



