package com.ipi.jva350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@CucumberContextConfiguration
@SpringBootTest
class CucumberSpringIntegrationTest {
    @Test
    void emptyTest(){
        Assertions.assertTrue(true);
    }
}