package edu.udb.sv.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import edu.udb.sv.Persona;
import edu.udb.sv.Repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository PersonaRepos;


    public List<Persona> obtenerTodas() {
        return PersonaRepos.findAll();
    }


    public Optional<Persona> obtenerPorId(Long id) {
        return PersonaRepos.findById(id);
    }


    public Persona guardar(Persona persona) {
        return PersonaRepos.save(persona);
    }


    public void eliminar(Long id) {
        PersonaRepos.deleteById(id);
    }
}
