package de.tekup.ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ds.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
