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
@Table(name="countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "country")
    @JsonProperty("country_name")
    private String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonProperty("createDate")
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    @JsonProperty("lastUpdate")
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country_id")
    private Set<Division> divisions;
}