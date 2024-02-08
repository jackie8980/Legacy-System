package com.shop.ecommerce.services;

import com.shop.ecommerce.dao.CustomerRepository;
import com.shop.ecommerce.dto.Purchase;
import com.shop.ecommerce.dto.PurchaseResponse;
import com.shop.ecommerce.entities.Cart;
import com.shop.ecommerce.entities.CartItem;
import com.shop.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the cart info from dto
        Cart cart = purchase.getCart();

        if (!purchase.getCartItems().isEmpty()) {
            //generate tracking number
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
            System.out.println(cart.getOrderTrackingNumber());

            //populate cart with cartItems
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));

            //populate customer with cart
            Customer customer = purchase.getCustomer();
            customer.add(cart);

            //set cart status to ordered
            cart.setStatus("ordered");

            //save to the database
            customerRepository.save(customer);

            return new PurchaseResponse(orderTrackingNumber);
        }

        //return a response
        return new PurchaseResponse("Cart is empty");
    }

    private String generateOrderTrackingNumber() {

        //generate a random Universally Unique Identifier (UUID) number
        return UUID.randomUUID().toString();

    }
}
