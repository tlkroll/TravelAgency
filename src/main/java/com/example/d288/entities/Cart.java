package com.example.d288.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {
    //public enum orderStatus { pending, ordered, canceled }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "package_price")
    @JsonProperty("package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    @JsonProperty("party_size")
    private Integer party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private StatusType status;

    @Column(name = "order_tracking_number")
    @JsonProperty("orderTrackingNumber")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonProperty("createDate")
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    @JsonProperty("lastUpdate")
    private Date lastUpdate;

    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {

        if (item != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }

            cartItems.add(item);
            item.setCarts(this);
        }
    }
}