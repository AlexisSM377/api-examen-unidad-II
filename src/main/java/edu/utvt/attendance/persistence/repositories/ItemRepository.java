package edu.utvt.attendance.persistence.repositories;

import edu.utvt.attendance.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNombre(String nombre);
}
