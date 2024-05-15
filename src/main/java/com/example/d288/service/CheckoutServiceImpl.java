package com.example.d288.service;

import com.example.d288.dao.CartRepository;
import com.example.d288.dao.CustomerRepository;
import com.example.d288.dto.Purchase;
import com.example.d288.dto.PurchaseResponse;
import com.example.d288.entities.Cart;
import com.example.d288.entities.CartItem;
import com.example.d288.entities.Customer;
import com.example.d288.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl (CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        String orderTrackingNumber = generateOrderTrackingNumber();

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setCustomer(purchase.getCustomer());
        cart.setStatus(StatusType.ordered);

        cartRepository.save(cart);
        customer.add(cart);
        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
