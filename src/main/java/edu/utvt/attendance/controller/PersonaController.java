package edu.utvt.attendance.controller;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable UUID id) {
        Persona persona = personaService.getPersonaById(id);
        return persona != null ? ResponseEntity.ok(persona) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Persona> getPersonasByNombre(@PathVariable String nombre) {
        return personaService.getPersonasByNombre(nombre);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable UUID id, @RequestBody Persona personaDetails) {
        Persona persona = personaService.getPersonaById(id);
        if (persona != null) {
            persona.setNombre(personaDetails.getNombre());
            persona.setEdad(personaDetails.getEdad());
            Persona updatedPersona = personaService.savePersona(persona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable UUID id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
}

