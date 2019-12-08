package org.erika.collector;

import java.util.*;

public class IterativeCollector implements Collector {
    private static final Character FIELD_SEPARATOR = ',';

    @Override
    public Collection<Integer> collect(String input) {
        if(input == null) {
            throw new IllegalArgumentException("Please provide valid input");
        }

        String [] arrayOfString = input.split (FIELD_SEPARATOR.toString());
        Set<Integer> numberSet = new TreeSet<>();

        for(String numberString: arrayOfString) {
            if(!numberString.isEmpty()) {
                numberSet.add(Integer.parseInt(numberString));
            }
        }

        return numberSet;
    }
}
