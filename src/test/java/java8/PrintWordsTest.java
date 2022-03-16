package java8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintWordsTest {

    private final List<String> words = new ArrayList<String>(List.of("itau", "serasa", "zup"));
    private final String newline = System.lineSeparator();
    private final String expectedString = String.join(newline, words).concat(newline);
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPrintWordsDefaultMethods() {
        Consumer<String> consumer = new ConsumerPrint();
        words.forEach(consumer);
        assertEquals(expectedString, outContent.toString());
    }

    @Test
    void testPrintWordsDefaultMethodsLambda() {
        words.forEach(s -> System.out.println(s));
        assertEquals(expectedString, outContent.toString());
    }

    @Test
    void testPrintWordsDefaultMethodsMethodReference() {
        words.forEach(System.out::println);
        assertEquals(expectedString, outContent.toString());
    }
}
