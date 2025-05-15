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
    private final Class<? extends Exception> expectedException;

    public LionDoesHaveManeParametrizedTest(String sex, Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters(name = "{index}: sex = {0}, expectedException = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", null},     // Нет исключения
                {"Самка", null},     // Нет исключения
                {"Олег", Exception.class}  // Ожидается исключение
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
        if (expectedException != null) {
            try {
                new Lion(sex, mockFeline);
                fail("Ожидалось исключение, но его не было");
            } catch (Exception e) {
                assertTrue(expectedException.isInstance(e));
                assertEquals(
                        "Используйте допустимые значения пола животного - самец или самка",
                        e.getMessage()
                );
            }
        } else {
            Lion lion = new Lion(sex, mockFeline);
            if ("Самец".equals(sex)) {
                assertTrue(lion.doesHaveMane());
            } else {
                assertFalse(lion.doesHaveMane());
            }
        }
        }
    }
