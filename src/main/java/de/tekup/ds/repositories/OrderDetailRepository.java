package de.tekup.ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ds.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
