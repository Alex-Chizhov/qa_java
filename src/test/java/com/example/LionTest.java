package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> list = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(list);
        List<String> actual = lion.getFood();
        assertEquals(list, actual);
    }

    @Test
    public void negativeSexTest(){
        try {
            Lion lion = new Lion("None", feline);
        } catch (Exception thrown){
            String actual = thrown.getMessage();
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals(expected, actual);
        }
    }
}
