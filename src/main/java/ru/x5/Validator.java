package ru.x5;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Validator {

    public boolean validate(String line) {
        List<Long> keys = countMatches(line);
        int matchNum = keys.size();
        if (matchNum < 2) return true;
        return matchNum == 2 && Math.abs(keys.get(0) - keys.get(1)) == 1;
    }

    private List<Long> countMatches(String line) {
        return line.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()))
                .values().stream()
                .distinct()
                .collect(toList());
    }
}