package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class LionUnknownSexExceptionTest {

    public LionUnknownSexExceptionTest() throws Exception {
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline mockFeline;

    @Test
    public void testExceptionMessageForInvalidSex() {
        try {
            new Lion("Другое", mockFeline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }


}
