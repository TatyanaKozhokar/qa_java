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
public class LionDoesHaveManeParametrizedTest {
    private final String sex;

    public LionDoesHaveManeParametrizedTest(String sex) {
        this.sex = sex;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец"},
                {"Самка"},
        });
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline mockFeline;

    @Test
    public void doesHaveManeTest() throws Exception {
            Lion lion = new Lion(sex, mockFeline);
            if ("Самец".equals(sex)) {
                assertTrue(lion.doesHaveMane());
            } else {
                assertFalse(lion.doesHaveMane());
            }
        }
    }
