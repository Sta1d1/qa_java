package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    @Mock
    Predator predator;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldReturnMockedFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> mockedFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(mockedFood);

        List<String> result = cat.getFood();
        assertEquals(mockedFood, result);
        verify(feline).eatMeat();

    }
}