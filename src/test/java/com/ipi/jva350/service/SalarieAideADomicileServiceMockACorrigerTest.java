 package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SalarieAideADomicileServiceMockACorrigerTest {

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;
    @InjectMocks
    private SalarieAideADomicileService salarieService = new SalarieAideADomicileService();



}
