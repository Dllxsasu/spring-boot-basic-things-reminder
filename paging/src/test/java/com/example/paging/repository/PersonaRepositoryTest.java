package com.example.paging.repository;

import com.example.paging.Persona;
import com.example.paging.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PersonaRepositoryTest {
    @Autowired
    private PersonaRepository personaRepository;

    @Test
    public void testFindByApellido() {
        // Crear algunas personas para la prueba
        Persona persona1 = new Persona();
        persona1.setNombre("Juan");
        persona1.setApellido("Pérez");
        personaRepository.save(persona1);

        Persona persona2 = new Persona();
        persona2.setNombre("María");
        persona2.setApellido("García");
        personaRepository.save(persona2);

        // Ejecutar la consulta
        List<Persona> personas = personaRepository.findByApellido("Pérez");

        // Verificar los resultados
        assertThat(personas).hasSize(1);
        assertThat(personas.get(0).getNombre()).isEqualTo("Juan");
    }
}
