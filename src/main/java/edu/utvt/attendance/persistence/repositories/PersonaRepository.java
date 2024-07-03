package edu.utvt.attendance.persistence.repositories;

import edu.utvt.attendance.persistence.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonaRepository extends JpaRepository<Persona, UUID> {
    List<Persona> findByNombre(String nombre);
}
