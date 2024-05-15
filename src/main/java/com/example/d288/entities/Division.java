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
@Table(name="divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    //@JsonProperty("id")
    private int id;

    @Column(name = "division")
    //@JsonProperty("division_name")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    //@JsonProperty("createDate")
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    //@JsonProperty("lastUpdate")
    private Date lastUpdate;

    @Column(name = "country_id")
    //@JsonProperty("country_id")
    private Long country_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country countryId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisions")
    private Set<Customer> customers;
}
