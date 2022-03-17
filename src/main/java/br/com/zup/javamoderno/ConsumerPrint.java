package br.com.zup.javamoderno;

import java.util.function.Consumer;

public class ConsumerPrint implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
