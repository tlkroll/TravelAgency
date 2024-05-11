package com.example.d288.service;

import com.example.d288.dto.Purchase;
import com.example.d288.dto.PurchaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
