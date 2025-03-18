 package com.ipi.jva350.service;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalarieAideADomicileServiceTest {

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;
    @InjectMocks
    private SalarieAideADomicileService salarieService;

     @Test
     void testCalculeLimiteEntrepriseCongesPermis() {
         LocalDate moisEnCours = LocalDate.of(2024, 3, 1);
         double congesAcquis = 25.0;
         LocalDate moisDebutContrat = LocalDate.of(2020, 1, 1);
         LocalDate premierJour = LocalDate.of(2024, 7, 1);
         LocalDate dernierJour = LocalDate.of(2024, 7, 15);

         when(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).thenReturn(0.0);

         long limite = salarieService.calculeLimiteEntrepriseCongesPermis(moisEnCours, congesAcquis, moisDebutContrat, premierJour, dernierJour);
         assertTrue(limite > 0);


     }
}
