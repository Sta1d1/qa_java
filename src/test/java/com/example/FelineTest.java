package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class FelineTest {
    @Spy
    Feline feline = Mockito.spy(new Feline());

    @Test
    void eatMeatShouldCallGetFoodWithPredatorAndReturnMockedValue() throws Exception {
        List<String> mockedFood = List.of("Мясо");

        Mockito.doReturn(mockedFood).when(feline).getFood("Хищник");
        List<String> result = feline.eatMeat();

        assertEquals(mockedFood, result);
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    void getFamilyWithoutArgumentsAndReturnTypeFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgumentsAndReturnCount1() {
        Mockito.doReturn(1).when(feline).getKittens(1);
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10, 20, 40, 100})
    void testGetKittensWithArgumentCountAndReturnCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}