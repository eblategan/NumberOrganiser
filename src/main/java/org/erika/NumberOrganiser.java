package org.erika;

import org.erika.collector.Collector;
import org.erika.summarizer.Summarizer;

import java.util.Collection;

public class NumberOrganiser implements NumberRangeSummarizer {
    private Collector collector;
    private Summarizer summarizer;

    public NumberOrganiser(Collector collector, Summarizer summarizer) {
        this.collector = collector;
        this.summarizer = summarizer;
    }

    @Override
    public Collection<Integer> collect(String input) {
        return this.collector.collect(input);
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return this.summarizer.summarizeCollection(input);
    }
}
