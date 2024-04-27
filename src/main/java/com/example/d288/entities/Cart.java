package com.example.d288.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {

    public enum orderStatus { pending, ordered, canceled }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cart_id")
    private Long id;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private Integer party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private orderStatus status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private Set<Cart_item> cartItems;


}