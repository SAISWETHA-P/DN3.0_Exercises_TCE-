package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.mapper.CustomerMapper;
import com.example.BookstoreAPI.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = Arrays.asList(
        new Customer(1, "John Doe", "john.doe@example.com"),
        new Customer(2, "Jane Doe", "jane.doe@example.com")
    );

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        Customer customer = customers.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);

        if (customer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        // Logic to save the customer (omitted for simplicity)
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customers.stream()
            .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
            .collect(Collectors.toList());
    }
}
