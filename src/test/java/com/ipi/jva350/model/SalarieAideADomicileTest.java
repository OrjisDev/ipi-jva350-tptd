package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;

class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesParDefaut() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertEquals(false, res); // TODO vérifie que Sonar demande amélioration
    }

    /**
     * Test représentatif du cas "n'a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesFalseTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(1);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        // avec 1j de travaillé, il est très peu probable d'avoir un jour de congés !
        Assertions.assertFalse(res);
    }

    /**
     * Test représentatif du cas "a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesTrueTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        // avec 100j de travaillé, il est très probable d'avoir un jour de congés !
        Assertions.assertTrue(res);
    }

    /* tests nominaux / typiques n'apportant rien de plus :
    @Test
    void testALegalementDroitADesCongesPayes100() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    @Test
    void testALegalementDroitADesCongesPayes101() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(101);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    */

    @Test
    void testALegalementDroitADesCongesPayesFalseAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(9);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testALegalementDroitADesCongesPayesTrueAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(10);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    void testUnitaireCalculeJoursDeCongeDecomptesPourPlage() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate>  res = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse("2022-11-01"), LocalDate.parse("2022-11-01"));
        // Then
        Assertions.assertNotNull(res);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(0, res.size());
    }

    @ParameterizedTest(name = "pour plage {0}-{1}, décompté : {2}")
    @CsvSource({
            "'2024-10-30', '2024-10-30', 1",
            "'2024-10-30', '2024-10-31', 2"
    })
    void testParametreCalculeJoursDeCongeDecomptesPourPlage(String dateDebutString, String dateFinString, int count) {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate> nbJoursDansPlage = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(dateDebutString), LocalDate.parse(dateFinString));
        // Then
        Assertions.assertNotNull(nbJoursDansPlage);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(count, nbJoursDansPlage.size());
    }

}