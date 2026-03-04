package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {

    @ParameterizedTest(name = "getKittens({0}) должен вернуть {0}")
    @ValueSource(ints = {0, 1, 2, 5, 10, 20, 40, 100})
    void testGetKittensWithArgumentCountAndReturnCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}