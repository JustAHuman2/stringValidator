package ru.x5;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Validator {

    public static boolean validate(String line) {
        Map<Character, Long> charsAmount = line.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        long minValue = charsAmount.values().stream().min(Long::compareTo).orElse(0l);
        return charsAmount.values().stream().mapToLong(num -> Math.abs(num - minValue)).sum() <= 1;
    }
}