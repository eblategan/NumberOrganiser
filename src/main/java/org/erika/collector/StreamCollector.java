package org.erika.collector;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollector implements Collector {

    private static final Character FIELD_SEPARATOR = ',';

    @Override
    public Collection<Integer> collect(String input) {
        if(input == null) {
            throw new IllegalArgumentException("Please provide valid input");
        }

        return splitString(input).stream()
                .filter(str -> !str.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    private Collection<String> splitString(String input) {
        return Stream.of(input)
                .map(s -> s.split(FIELD_SEPARATOR.toString()))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

}
