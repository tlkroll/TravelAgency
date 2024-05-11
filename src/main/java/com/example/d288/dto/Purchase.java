package com.example.d288.dto;

import com.example.d288.entities.Cart;
import com.example.d288.entities.CartItem;
import com.example.d288.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
