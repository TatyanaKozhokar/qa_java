package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
        Feline feline = new Feline();
        assertEquals(input, feline.getKittens(input));
    }
}
