package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AnimalTest {
    private final Animal animal = new Animal();

    @Test
    void getFoodWithHerbivoreReturnGrassAndVariousPlants() throws Exception {
        List<String> result = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), result);
    }

    @Test
    void getFoodWithPredatorReturnAnimalsBirdsFish() throws Exception {
        List<String> result = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    void getFoodWithUnknownAnimalReturnExceptionUnknowAnimal() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void getFamilyWithoutParametersReturnString() {
        String result = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", result);
    }
}