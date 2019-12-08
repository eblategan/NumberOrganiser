package org.erika;

import org.erika.collector.Collector;
import org.erika.collector.StreamCollector;

public class StreamCollectorTest implements CollectInterfaceTest {
    @Override
    public Collector getCollector() {
        return new StreamCollector();
    }
}
