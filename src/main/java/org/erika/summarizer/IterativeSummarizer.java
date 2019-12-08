package org.erika.summarizer;

import java.util.Collection;

public class IterativeSummarizer implements Summarizer {

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        Integer[] array = new Integer[input.size()];
        input.toArray(array);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1] - 1) {
                output.append(array[i] + "-");
                while (i < array.length - 1) {

                    if (array[i] != array[i + 1] - 1) {
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
