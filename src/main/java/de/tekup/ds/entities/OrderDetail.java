package de.tekup.ds.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "orderdetail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int qty;
    private float tax;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    public float calculateTotal(){
        return item.getPrice()*qty + tax;
    }

    public float calculateWeight(){
        return item.getWeight()*qty;
    }
}
