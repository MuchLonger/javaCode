package cn.lear.text;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Cache<String> cache1 = new Cache<String>();
        cache1.setValue("123");
        System.out.println(cache1.getClass());
        String value2 = cache1.getValue();

        Cache<Integer> cache2 = new Cache<Integer>();
        cache2.setValue(456);
        int value3 = cache2.getValue();
        System.out.println(cache2.getClass());


    }

}
class Cache<T> {
    T value;
    String key;
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
