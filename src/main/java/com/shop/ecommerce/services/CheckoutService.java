package com.shop.ecommerce.services;

import com.shop.ecommerce.dto.Purchase;
import com.shop.ecommerce.dto.PurchaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
