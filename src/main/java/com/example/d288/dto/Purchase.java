package com.example.d288.dto;

import com.example.d288.entities.Cart;
import com.example.d288.entities.Cart_item;
import com.example.d288.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<Cart_item> cart_itemSet;
}
