package org.erika;

import org.erika.summarizer.IterativeSummarizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IterativeSummarizerTest {

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
