package com.ipi.jva350.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static com.ipi.jva350.model.Entreprise.getPremierJourAnneeDeConges;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EntrepriseTest {


    @ParameterizedTest
    @CsvSource({
            "2024-03-15, 2024-03-15, 2024-03-20, true",  // Début inclus
            "2024-03-17, 2024-03-15, 2024-03-20, true",  // Milieu
            "2024-03-10, 2024-03-15, 2024-03-20, false", // Avant la plage
            "2024-03-25, 2024-03-15, 2024-03-20, false", // Après la plage
            "2024-03-15, 2024-03-15, 2024-03-15, true",  // Début == Fin
            "2024-03-15, 2024-03-20, 2024-03-15, false"  // Plage inversée
    })
    void testEstDansPlage(String dateStr, String debutStr, String finStr, boolean expected) {
        LocalDate date = LocalDate.parse(dateStr);
        LocalDate debut = LocalDate.parse(debutStr);
        LocalDate fin = LocalDate.parse(finStr);
        assertEquals(expected, Entreprise.estDansPlage(date, debut, fin));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-01-01, true",  // Jour de l'An
            "2024-04-01, true",  // Lundi de Pâques
            "2024-07-14, true",  // Fête nationale
            "2024-12-25, true",  // Noël
            "2024-06-15, false"  // Jour non férié
    })
    void testEstJourFerie(String dateStr, boolean expected) {
        LocalDate date = LocalDate.parse(dateStr);
        assertEquals(expected, Entreprise.estJourFerie(date));
    }

    @ParameterizedTest
    @CsvSource({
            "2025-04-01, 0.9333333333333333",
            "2025-05-01, 1.0",
            "2025-06-01, 0.06666666666666667",
            "2025-07-01, 0.23333333333333334",
            "2025-08-01, 0.4"
    })
    void testProportionPondereeDuMois(String dateStr, double expectedValue) {
        LocalDate date = LocalDate.parse(dateStr);
        assertEquals(expectedValue, Entreprise.proportionPondereeDuMois(date));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-03-15,2023-06-01",
            "2024-07-10,2024-06-01",
            "2024-06-01,2024-06-01"
    })
    void testPremierJourDeCongé(String dateStr, String dateExpected) {
        LocalDate date = LocalDate.parse(dateStr);
        LocalDate dateExp = LocalDate.parse(dateExpected);
        assertEquals(dateExp, getPremierJourAnneeDeConges(date));
    }


}
