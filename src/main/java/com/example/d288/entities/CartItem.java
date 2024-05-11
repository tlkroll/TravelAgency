package com.example.d288.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    //@JsonProperty("cartItemId")
    private Long cartItemId;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonProperty("createDate")
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    //@JsonProperty("lastUpdate")
    private Date lastUpdate;

    @Column(name = "cart_id")
    @JsonProperty("cartId")
    private Long cartId;

    @Column(name = "vacation_id")
    //@JsonProperty("vacation")
    private Long vacation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
    private Cart carts;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"),
    inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;
}