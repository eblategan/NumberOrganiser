package org.erika;

import org.erika.collector.IterativeCollector;
import org.erika.collector.StreamCollector;
import org.erika.summarizer.IterativeSummarizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class NumberOrganiserTest {

    private NumberOrganiser numberOrganiser =
            new NumberOrganiser(new StreamCollector(), new IterativeSummarizer());

    @Test
    @DisplayName("test collect")
    void testCollect() {
        final String input = "1,2,10,20,40";
        final List<Integer> expectedOutput = Arrays.asList(1,2,10,20,40);
        final Collection<Integer> output = numberOrganiser.collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test summarize collection")
    void testSummarizeCollection() {
        IterativeSummarizer summarizer = new IterativeSummarizer();
        final List<Integer> input = Arrays.asList(1,2,10,20,40);
        final String expectOutput = "1-2, 10, 20, 40";
        final String output = summarizer.summarizeCollection(input);

        assertEquals(expectOutput, output);
    }
}
