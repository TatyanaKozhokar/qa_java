package com.example;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Animal mockAnimal;

    @Test
    public void eatMeat_returns_PredatorsMealTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockAnimal.getFood("Хищник")).thenReturn(expectedFood);
        Feline feline = new Feline(mockAnimal);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamily_returns_Feline_Test() {
        Feline feline = new Feline(mockAnimal);
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameters() {
        Feline felineSpy = spy(new Feline(mockAnimal));
        assertEquals(1, felineSpy.getKittens());
        verify(felineSpy).getKittens(1);
    }

}