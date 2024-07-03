package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Persona;

import java.util.List;
import java.util.UUID;

public interface PersonaService {

    List<Persona> getAllPersonas();
    Persona getPersonaById(UUID id);
    List<Persona> getPersonasByNombre(String nombre);
    Persona savePersona(Persona persona);
    void deletePersona(UUID id);
}
