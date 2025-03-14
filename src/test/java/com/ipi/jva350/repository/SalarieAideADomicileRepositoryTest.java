package com.ipi.jva350.repository;


import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@DataJpaTest // ou carrément @SpringBootTest et sa configuration
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @BeforeEach
    void before() {
        // (pas besoin normalement, la base en mémoire est recrée à chaque test)
        //repository.deleteAll();
        //Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    void testFindByNomNotFoundNominal() {
        // Given :
        String testNom = "Pierre";
        // When :
        SalarieAideADomicile salarieTrouve = salarieAideADomicileRepository.findByNom(testNom);
        // Then :
        Assertions.assertEquals(null, salarieTrouve);
    }

    @Test
    void testFindByNomFoundNominal() {
        // Given :
        String testNom = "Pierre";
        SalarieAideADomicile newSalarie = new SalarieAideADomicile(
                testNom, LocalDate.of(2023, 5, 1), LocalDate.of(2025, 02, 01),
                18.0, 21.0, 200.0, 25.0, 1.0);
        salarieAideADomicileRepository.save(newSalarie);
        // When :
        SalarieAideADomicile salarieTrouve = salarieAideADomicileRepository.findByNom(testNom);
        // Then :
        Assertions.assertNotNull(salarieTrouve);
        Assertions.assertEquals(testNom, salarieTrouve.getNom());
    }

}
