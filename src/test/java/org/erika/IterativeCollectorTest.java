package org.erika;

import org.erika.collector.Collector;
import org.erika.collector.IterativeCollector;

public class IterativeCollectorTest implements CollectInterfaceTest {
    @Override
    public Collector getCollector() {
        return new IterativeCollector();
    }
}
