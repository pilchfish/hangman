package com.example.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }


    @Test
    void checkIfAllLettersFoundTest() {

        char[] charArr1 = {'h', 'e', 'l', 'l', 'o'};
        char[] charArr2 = {'h', 'e', 'l', 'l', 'o'};
        assertEquals(true, App.checkIfAllLettersFound(charArr1, charArr2));
    }
}
