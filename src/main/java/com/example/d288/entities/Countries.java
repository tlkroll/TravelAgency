package com.example.d288.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="countries")
@Data
public class Countries {
    private Long country_id;
    private String country;
    private Date create_date;
    private Date last_update;
}