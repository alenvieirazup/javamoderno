package java8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortWordsTest {

    private List<String> expectedList;
    private List<String> words;
    private final Comparator comparator = new ComparatorStringLength();;

    @BeforeEach
    void setup() {
        expectedList = new ArrayList<String>(List.of("zup", "itau", "serasa"));
        words = new ArrayList<String>(List.of("itau", "serasa", "zup"));
    }

    @Test
    void testSortWordsCollections() {
        Collections.sort(words, comparator);
        assertEquals(expectedList, words);
    }

    @Test
    void testSortWordsDefaultMethods() {
        words.sort(comparator);
        assertEquals(expectedList, words);
    }

    @Test
    void testSortWordsDefaultMethodsLambda() {
        words.sort((s1, s2) -> s1.length() - s2.length());
        assertEquals(expectedList, words);
    }

    @Test
    void testSortWordsDefaultMethodsComparingLambda() {
        words.sort(comparing(s -> s.length()));
        assertEquals(expectedList, words);
    }

    @Test
    void testSortWordsDefaultMethodsComparingMethodReference() {
        words.sort(comparing(String::length));
        assertEquals(expectedList, words);
    }
}
