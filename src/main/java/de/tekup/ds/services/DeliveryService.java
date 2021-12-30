package de.tekup.ds.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.ds.entities.Delivery;
import de.tekup.ds.repositories.DeliveryRepository;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public String LivreurplusRapide(){
        return deliveryRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Delivery::getDeliveryMan))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        d -> d.getValue()
                                .stream()
                                .mapToLong(delivery -> delivery.getDeliveryDate().getTime() - delivery.getShoppingDate().getTime()
                                ).average().getAsDouble()))
                .entrySet()
                .stream()
                .max((x1, x2) -> x1.getValue() > x2.getValue() ?1:-1)
                .get().getKey();
    }
    public String livreurplusLente(){
        return deliveryRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Delivery::getDeliveryMan))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        d -> d.getValue()
                                .stream()
                                .mapToLong(delivery -> delivery.getDeliveryDate().getTime() - delivery.getShoppingDate().getTime()
                                ).average().getAsDouble()))
                .entrySet()
                .stream()
                .min((x1, x2) -> x1.getValue() > x2.getValue() ?1:-1)
                .get().getKey();
    }

}
