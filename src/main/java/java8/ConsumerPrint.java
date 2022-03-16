package java8;

import java.util.function.Consumer;

public class ConsumerPrint implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
