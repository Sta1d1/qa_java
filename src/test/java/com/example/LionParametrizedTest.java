package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParametrizedTest {

    @ParameterizedTest(name = "Пол={0}. Должен вернуть={1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeWhenMaleShouldReturnBoolean(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(expectedHasMane, lion.doesHaveMane(), sex + " должно быть " + expectedHasMane);
    }
}
