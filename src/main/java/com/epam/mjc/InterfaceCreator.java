package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return result -> result.stream().allMatch(listElement -> Character.isUpperCase(listElement.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return result -> result.addAll(result.stream().filter(x -> x%2==0).collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(f -> Character.isUpperCase(f.charAt(0)))
                .filter(f -> f.endsWith("."))
                .filter(f -> f.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return result -> result.stream().collect(Collectors.toMap(Function.identity(),String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (result1, result2) -> Stream.concat(result1.stream(), result2.stream()).collect(Collectors.toList());
    }
}
