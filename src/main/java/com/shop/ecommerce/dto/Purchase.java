package com.shop.ecommerce.dto;

import com.shop.ecommerce.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
    private Vacation vacation;
    private Excursion excursion;
    private Division division;
    private Country country;
}
