package br.com.zup.javamoderno;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StreamWords {

    private final List<String> words = List.of("itau", "serasa", "zup");
    private final String newline = System.lineSeparator();
    private final String expectedString = String.join(newline, words).concat(newline);
    private ByteArrayOutputStream outContent;

    @Test
    void testStreamFilter() {
        List<String> words_filter = words.stream().filter(w -> w.length() > 3).toList();
        List<String> expected = List.of("itau", "serasa");
        assertEquals(expected, words_filter);
    }

    @Test
    void testStreamMap() {
        List<Integer> words_length = words.stream().map(String::length).toList();
        List<Integer> expected = List.of(4, 6, 3);
        assertEquals(expected, words_length);
    }

    @Test
    void testStreamForEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        words.stream().forEach(System.out::println);
        assertEquals(expectedString, outContent.toString());
    }

    @Test
    void testStreamMapToIntFilterSum() {
        int sum = words.stream().mapToInt(String::length).filter(x -> x > 3).sum();
        assertEquals(10, sum);
    }

    @Test
    void testStreamFilterAny(){
        Optional<String> optional = words.stream().filter(w -> w.length() > 4).findAny();
        assertFalse(optional.isEmpty());
    }

    @Test
    void testStreamFilterAnyOrElse(){
        Optional<String> optional = words.stream().filter(w -> w.length() > 10).findAny();
        String word = optional.orElse("");
        assertEquals("", word);
    }

    @Test
    void testStreamFilterAnyIfPresent(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "zup".concat(newline);
        words.stream().filter(w -> w.length() == 3).findAny().ifPresent(w -> System.out.println(w));
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testStreamToMap(){
        Map<String, Integer> expected = Map.of("itau", 4, "serasa", 6, "zup", 3);
        Map<String, Integer> map = words.stream().collect(Collectors.toMap(w -> w, w-> w.length()));
        assertEquals(expected, map);
    }

}
