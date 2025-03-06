package edu.udb.sv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.udb.sv.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
