package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    Feline feline;

    @Test
    void eatMeatShouldCallGetFoodWithPredatorAndReturnMockedValue() throws Exception {
        List<String> mockedFood = List.of("Мясо");

        Mockito.doReturn(mockedFood).when(feline).getFood("Хищник");
        List<String> result = feline.eatMeat();

        assertEquals(mockedFood, result);
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    void getFamilyShouldReturnFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensShouldReturnValueOne() {
        Mockito.doReturn(1).when(feline).getKittens(1);
        assertEquals(1, feline.getKittens());
    }

}