package br.com.zup.javamoderno;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparatorStringLengthTest {
    private Comparator<String> comparator = new ComparatorStringLength();

    @Test
    void testCompareStringEqualsLength() {
        int result = comparator.compare("zup", "zup");
        assertEquals(0, result);
    }

    @Test
    void testCompareFirstLongestString() {
        int result = comparator.compare("itau", "zup");
        assertEquals(1, result);
    }

    @Test
    void testCompareSecondLongestString() {
        int result = comparator.compare("zup", "itau");
        assertEquals(-1, result);
    }
}