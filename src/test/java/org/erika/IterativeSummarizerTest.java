package org.erika;

import org.erika.summarizer.IterativeSummarizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IterativeSummarizerTest {

    private IterativeSummarizer summarizer = new IterativeSummarizer();

    @Test
    @DisplayName("test summarize collection")
    void testSummarizeCollection() {
        final List<Integer> input = Arrays.asList(1, 2, 10, 20, 40);
        final String expectOutput = "1-2, 10, 20, 40";
        final String output = summarizer.summarizeCollection(input);
        assertEquals(expectOutput, output);
    }

    @Test
    @DisplayName("test summarize collection with duplicates")
    void testSummarizeCollectionWithDuplicates() {
        final List<Integer> input = Arrays.asList(1, 2, 2, 2, 2, 10, 20, 40);
        final String expectOutput = "1-2, 10, 20, 40";
        final String output = summarizer.summarizeCollection(input);
        assertEquals(expectOutput, output);
    }

    @Test
    @DisplayName("test summarize collection with erroneous out of order input")
    void testSummarizeCollectionWithOutOfOrderInput() {
        final List<Integer> input = Arrays.asList(-5, -6, -7, -8, 1, 2, 10, 20, 40);
        assertThrows(IllegalArgumentException.class, () -> summarizer.summarizeCollection(input));
    }

    @Test
    @DisplayName("test summarize collection with negative number input")
    void testSummarizeCollectionWithNegativeNumberInput() {
        final List<Integer> input = Arrays.asList(-12, -8, -7, -6, -5, 1, 2, 3, 10);
        final String expectOutput = "-12, -8--5, 1-3, 10";
        final String output = summarizer.summarizeCollection(input);
        assertEquals(expectOutput, output);
    }

    @Test
    @DisplayName("test summarize with null input")
    void testSummarizeWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> summarizer.summarizeCollection(null));
    }
}
