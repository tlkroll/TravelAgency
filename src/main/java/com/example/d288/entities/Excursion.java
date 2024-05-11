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
@Table(name="excursions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    //@JsonProperty("id")
    private Long id;

    @Column(name = "create_date")
    @CreationTimestamp
    //@JsonProperty("create_date")
    private Date create_date;

    @Column(name = "excursion_price")
    //@JsonProperty("excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "excursion_title")
    //@JsonProperty("excursion_title")
    private String excursion_title;

    @Column(name = "image_url")
    //@JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "last_update")
    @UpdateTimestamp
    //@JsonProperty("last_update")
    private Date last_update;

    @Column(name = "vacation_id")
    @JsonProperty("vacationId")
    private Long vacationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    private Vacation vacations;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}
