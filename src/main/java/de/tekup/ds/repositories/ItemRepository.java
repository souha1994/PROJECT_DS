package de.tekup.ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ds.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
