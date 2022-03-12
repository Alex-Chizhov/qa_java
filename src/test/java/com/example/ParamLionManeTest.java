package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParamLionManeTest {

    private final String sex;
    private final boolean expected;

    public ParamLionManeTest(String sex,  boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false },
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}