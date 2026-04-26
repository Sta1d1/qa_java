package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;


    @Test
    void constructorWhenSexIsMaleShouldSetHasManeTrue() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void constructorWhenSexIsFemaleShouldSetHasManeFalse() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructorWhenSexIsInvalidValueShouldSetHasManeTrue() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensShouldReturnCorrectKittensValue() throws Exception {
        Lion lion = new Lion("Самец");
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    void getFoodShouldReturnCorrectFood() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> expectedFood = Arrays.asList("Мясо", "Птица");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        java.lang.reflect.Field field = Lion.class.getDeclaredField("feline");
        field.setAccessible(true);
        field.set(lion, feline);

        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Метод getFood должен возвращать список еды от feline");
        Mockito.verify(feline).getFood("Хищник");
    }
}