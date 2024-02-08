package com.shop.ecommerce.bootstrap;

import com.shop.ecommerce.dao.CustomerRepository;
import com.shop.ecommerce.dao.DivisionRepository;
import com.shop.ecommerce.entities.Customer;
import com.shop.ecommerce.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //start with fresh set of customers
        customerRepository.deleteAll();

        if (customerRepository.count() == 0) {
            Customer jack = new Customer();
            jack.setFirstName("Jack");
            jack.setLastName("Son");
            jack.setAddress("86 Englewood Ave");
            jack.setPostal_code("14214");
            jack.setPhone("(917)123-1234");
            jack.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(jack);

            Customer drew = new Customer();
            drew.setFirstName("Drew");
            drew.setLastName("Drew");
            drew.setAddress("3942 Glenwick Dr");
            drew.setPostal_code("34772");
            drew.setPhone("(917)153-3428");
            drew.setDivision(divisionRepository.getReferenceById(9L));
            customerRepository.save(drew);

            Customer jane = new Customer();
            jane.setFirstName("Jane");
            jane.setLastName("Doe");
            jane.setAddress("280 Cold St");
            jane.setPostal_code("05405");
            jane.setPhone("(718)257-5432");
            jane.setDivision(divisionRepository.getReferenceById(44L));
            customerRepository.save(jane);

            Customer sang = new Customer();
            sang.setFirstName("Peter");
            sang.setLastName("Sang");
            sang.setAddress("715 Hoomoana St");
            sang.setPostal_code("96782");
            sang.setPhone("(646)216-5430");
            sang.setDivision(divisionRepository.getReferenceById(52L));
            customerRepository.save(sang);

            Customer dan = new Customer();
            dan.setFirstName("Dan");
            dan.setLastName("Lee");
            dan.setAddress("154 River Dr");
            dan.setPostal_code("99737");
            dan.setPhone("(839)735-8262");
            dan.setDivision(divisionRepository.getReferenceById(54L));
            customerRepository.save(dan);
        }


    }
}
