package com.example.d288.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country_id")
    private Set<Division> divisions;
}