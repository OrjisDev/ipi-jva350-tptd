package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EntrepriseTest {


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
        Assertions.assertEquals(expected, Entreprise.estDansPlage(date, debut, fin));
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
        Assertions.assertEquals(expected, Entreprise.estJourFerie(date));
    }




}
