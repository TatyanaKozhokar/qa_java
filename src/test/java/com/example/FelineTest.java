package com.example;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        Animal animal = new Animal();
        feline = new Feline(animal);
    }

    @Test
    public void eatMeat_returns_PredatorsMealTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamily_returns_Feline_Test() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameters() {
        assertEquals(1, feline.getKittens());
    }

}