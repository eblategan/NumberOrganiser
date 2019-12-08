package org.erika;

import org.erika.collector.Collector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public interface CollectInterfaceTest {

    Collector getCollector();

    @Test
    @DisplayName("test most basic collection")
    default void testCollectBasic() {
        final String input = "1,2,5,10";
        final List<Integer> expectedOutput = Arrays.asList(1, 2, 5, 10);
        final Collection<Integer> output = getCollector().collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test collection with duplicates")
    default void testCollectDuplicates() {
        final String input = "1,2,2,20,40,50,50,50";
        final List<Integer> expectedOutput = Arrays.asList(1, 2, 20, 40, 50);
        final Collection<Integer> output = getCollector().collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test collection for out of order input")
    default void testCollectSorted() {
        final String input = "5,10,4,7";
        final List<Integer> expectedOutput = Arrays.asList(4, 5, 7, 10);
        final Collection<Integer> output = getCollector().collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test collection with bad input")
    default void testCollectWithBadInput() {
        final String input = "1,,,,@2,5,10";
        assertThrows(NumberFormatException.class, () -> getCollector().collect(input));
    }

    @Test
    @DisplayName("test collection with empty inputs")
    default void testCollectWithEmptyInputs() {
        final String input = "5,10,,,4,,7";
        final List<Integer> expectedOutput = Arrays.asList(4, 5, 7, 10);
        final Collection<Integer> output = getCollector().collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test collection with negative number inputs")
    default void testCollectNegativeNumberInputs() {
        final String input = "5,10,-2,-5,4,-1,7,-3";
        final List<Integer> expectedOutput = Arrays.asList(-5, -3, -2, -1, 4, 5, 7, 10);
        final Collection<Integer> output = getCollector().collect(input);
        assertIterableEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("test collection with null input")
    default void testCollectWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> getCollector().collect(null));
    }
}
