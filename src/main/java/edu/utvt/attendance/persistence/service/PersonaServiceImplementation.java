package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonaServiceImplementation implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(UUID id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> getPersonasByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deletePersona(UUID id) {
        personaRepository.deleteById(id);

    }
}
