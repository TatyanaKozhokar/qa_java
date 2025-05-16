package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int input;

    public FelineParametrizedTest(int input) {
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0},
                {1},
                {3},
                {-3}
        });
    }

    @Test
    public void getKittensParametrized() {
        Animal animal = new Animal();
        Feline feline = new Feline(animal);
        assertEquals(input, feline.getKittens(input));
    }
}
