package de.tekup.ds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ds.entities.Customer;
import de.tekup.ds.services.CustomerService;
import de.tekup.ds.services.DeliveryService;

@RestController
@RequestMapping("/get")
public class TestController {
    private final CustomerService customerService;
    private final DeliveryService deliveryService;

    @Autowired
    public TestController(CustomerService customerService, DeliveryService deliveryService) {
        this.customerService = customerService;
        this.deliveryService = deliveryService;
    }
    @GetMapping("/plusRapide")
    public String LivreurplusRapide(){
        return deliveryService.LivreurplusRapide();
    }
    @GetMapping("/plusLente")
    public String livreurplusLente(){
        return deliveryService.livreurplusLente();
    }

    @GetMapping("/TopCinqClientsDepenses")
    public List<Customer> TopCinqClientsDepenses(){
        return customerService.TopCinqClientsDepenses();
    }
    @GetMapping("/TopCinqClientsenlivraisony")
    public List<Customer> TopCinqClientsenlivraison(){
        return customerService.TopCinqClientsenlivraison();
    }
    @GetMapping("Clientcommandesplus10kg")
    public List<Customer> Clientcommandesplus10kg(){
        return customerService.Clientcommandesplus10kg();
    }
   

}
