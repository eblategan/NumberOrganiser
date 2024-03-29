package org.erika.summarizer;

import java.util.Collection;

public class IterativeSummarizer implements Summarizer {

    private boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0)
                return false;
        }
        return true;
    }

    private boolean containsNulls(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null)
                return true;
        }
        return false;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if(input == null) {
            throw new IllegalArgumentException("Please provide valid input");
        }

        Integer[] array = new Integer[input.size()];
        input.toArray(array);

        if(!isSorted(array)) {
            throw new IllegalArgumentException("input must be sorted");
        }
        if(containsNulls(array)) {
            throw new IllegalArgumentException("input must not contain nulls");
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1]) {
                continue;
            }

            if (array[i] == array[i + 1] - 1) {
                output.append(array[i] + "-");
                while (i < array.length - 1) {
                    if (array[i] != array[i + 1] - 1 && array[i] != array[i + 1]) {
                        output.append(array[i] + ", ");
                        break;
                    }
                    i++;
                }
            } else {
                output.append(array[i] + ", ");
            }
        }
        output.append(array[array.length - 1]);
        return output.toString();
    }
}
