package com.example.d288.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    //@JsonProperty("id")
    private Long id;

    @Column(name = "address", nullable = false)
    //@JsonProperty("address")
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    //@JsonProperty("createDate")
    private Date createDate;

    @Column(name = "customer_first_name", nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    //@JsonProperty("lastName")
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    //@JsonProperty("lastUpdate")
    private Date lastUpdate;

    @Column(name = "phone", nullable = false)
    //@JsonProperty("phone")
    private String phone;

    @Column(name = "postal_code", nullable = false)
    //@JsonProperty("postal_code")
    private String postal_code;

    @Column(name = "division_id", nullable = false)
    //@JsonProperty("division_id")
    private int division_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false, insertable = false, updatable = false)
    private Division divisions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;
    public void add(Cart cart) {

        if (carts != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }

            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}