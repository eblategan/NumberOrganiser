package org.erika;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOrganiserTest {

    private NumberOrganiser numberOrganiser = new NumberOrganiser();

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
