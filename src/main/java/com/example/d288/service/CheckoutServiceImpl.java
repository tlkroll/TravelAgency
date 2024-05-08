package com.example.d288.service;

import com.example.d288.dao.CustomerRepository;
import com.example.d288.dto.Purchase;
import com.example.d288.dto.PurchaseResponse;
import com.example.d288.entities.Cart;
import com.example.d288.entities.Cart_item;
import com.example.d288.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<Cart_item> cart_itemSet = purchase.getCart_itemSet();
        cart_itemSet.forEach(cart_item -> cart.add(cart_item));

        cart.setCartItems(purchase.getCart_itemSet());
        cart.setCustomer(purchase.getCustomer());

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        customerRepository.save(customer);

        return new PurchaseResponse();
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
