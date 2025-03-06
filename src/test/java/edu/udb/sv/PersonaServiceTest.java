package edu.udb.sv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import edu.udb.sv.Repository.PersonaRepository;
import edu.udb.sv.Services.PersonaService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PersonaRepository personaRepository;

    private Persona persona;


    @Test
    public void GuardarPersona() {

        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombrePersona("Carlos");
        nuevaPersona.setEdadPersona(30);
        nuevaPersona.setTelefonoPersona("987654321");
        nuevaPersona.setSexoPersona("Masculino");
        nuevaPersona.setIdOcupacion(2);
        nuevaPersona.setFechaNac(java.sql.Date.valueOf("1993-05-15"));
        Persona savedPersona = personaService.guardar(nuevaPersona);

    }

    @Test
    public void SelectPersona() {

        Long idBuscado = 61L;
        Optional<Persona> foundPersona = personaService.obtenerPorId(idBuscado);

        assertTrue(foundPersona.isPresent(), "La persona con ID " + idBuscado + " no fue encontrada.");

        assertEquals("Carlos", foundPersona.get().getNombrePersona(), "El nombre de la persona no coincide.");
    }


    @Test
    public void ActualizarDatosPersona() {

        Long idBuscado = 61L;
        Optional<Persona> personaExistente = personaService.obtenerPorId(idBuscado);

        assertTrue(personaExistente.isPresent(), "La persona con ID " + idBuscado + " no fue encontrada antes de actualizarla.");

        Persona persona = personaExistente.get();
        persona.setNombrePersona("Alejandro");
        Persona updatedPersona = personaService.guardar(persona);

        assertEquals("Alejandro", updatedPersona.getNombrePersona(), "El nombre de la persona no fue actualizado correctamente.");
    }


    @Test
    public void EliminarPersona() {
        Long idBuscado = 61L;
        Optional<Persona> personaExistente = personaService.obtenerPorId(idBuscado);

        assertTrue(personaExistente.isPresent(), "La persona con ID " + idBuscado + " no fue encontrada antes de eliminarla.");

        personaService.eliminar(idBuscado);

        Optional<Persona> deletedPersona = personaService.obtenerPorId(idBuscado);
        assertFalse(deletedPersona.isPresent(), "La persona con ID " + idBuscado + " no fue eliminada correctamente.");
    }
}
