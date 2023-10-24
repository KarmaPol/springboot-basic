package com.pgms.part1.domain.customer.service;

import com.pgms.part1.domain.customer.dto.CustomerResponseDto;
import com.pgms.part1.domain.customer.entity.Customer;
import com.pgms.part1.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> listBlockedCustomers(){
        List<Customer> customers = customerRepository.listBlockedCustomers();
        return customers.stream().map(customer ->
                new CustomerResponseDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getBlocked()))
                .collect(Collectors.toList());
    }

    public List<CustomerResponseDto> listCustomers(){
        List<Customer> customers = customerRepository.listCustomers();
        return customers.stream().map(customer ->
                        new CustomerResponseDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getBlocked()))
                .collect(Collectors.toList());
    }

    public void addCustomer(Customer customer){
        customerRepository.addCustomer(customer);
    }

    public void updateCustomerName(Customer customer, String name){
        customerRepository.updateCustomerName(customer, name);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.deleteCustomer(customer);
    }
}
