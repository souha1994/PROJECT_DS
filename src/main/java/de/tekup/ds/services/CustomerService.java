package de.tekup.ds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.ds.entities.Customer;
import de.tekup.ds.entities.OrderDetail;
import de.tekup.ds.repositories.CustomerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> TopCinqClientsenlivraison(){
        return customerRepository.findAll().stream()
                .sorted(Comparator.comparingInt(customer -> customer.getOrders().size()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Customer> TopCinqClientsDepenses(){
         return customerRepository.findAll().stream()
                .collect(Collectors.toMap(customer -> customer,
                        customer -> customer.getOrders().stream()
                                .mapToDouble(order -> order.getOrderDetails().stream()
                                        .mapToDouble(OrderDetail::calculateTotal).sum())
                                .sum()
                ))
                 .entrySet()
                 .stream()
                 .sorted((x1, x2) -> (int)(x1.getValue() - x2.getValue()))
                 .limit(5)
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toList());

    }

    public List<Customer> Clientcommandesplus10kg(){
        return customerRepository.findAll().stream()
                .filter(customer ->
                        customer.getOrders().stream().anyMatch(order -> order.getOrderDetails().stream()
                                .map(OrderDetail::calculateWeight).findAny().isPresent())
                ).collect(Collectors.toList());
    }

}
