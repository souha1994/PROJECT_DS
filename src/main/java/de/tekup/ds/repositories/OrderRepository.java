package de.tekup.ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ds.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
