package org.erika;

import org.erika.collector.IterativeCollector;
import org.erika.summarizer.IterativeSummarizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOrganiserTest {

    private NumberOrganiser numberOrganiser =
            new NumberOrganiser(new IterativeCollector(), new IterativeSummarizer());

    @Test
    @DisplayName("test collect")
    void testCollect() {
        numberOrganiser.collect("1,2,10,20,40");
    }

    @Test
    @DisplayName("test summarize collection")
    void testSummarizeCollection() {
        numberOrganiser.summarizeCollection(null);
    }
}
