package com.example.d288.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonProperty("create_date")
    private Date create_date;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "last_update")
    @UpdateTimestamp
    @JsonProperty("last_update")
    private Date last_update;

    @Column(name = "travel_fare_price")
    @JsonProperty("travel_price")
    private BigDecimal travel_price;

    @Column(name = "vacation_title")
    @JsonProperty("vacation_title")
    private String vacation_title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacations")
    private Set<Excursion> excursions;
}