package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline mockFeline;

    @Test
    public void getLionKittensTest() throws Exception {
        when(mockFeline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самка", mockFeline);
        assertEquals(1, lion.getKittens());
        verify(mockFeline).getKittens();
    }

    @Test
    public void getFoodTest_returns_PredatorsMealTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", mockFeline);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}