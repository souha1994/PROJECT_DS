package de.tekup.ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ds.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
