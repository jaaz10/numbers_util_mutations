package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {
    /**
     *
     * Step 1: understand the requirement, input type and output type
     *        Requirement: Add two list of integer, index by index, and returns another list
     *
     * Step 2 (raw):  Perform partition and boundary analysis on input and output
     *        Each input: left | right
     *        Combination of input:
     *        Output:
     *  Step 3: Derive potential test cases
     *
     */
    // test null inputs return null
    @Test
    void testNullInputs() {
        assertNull(NumberUtils.add(null, Arrays.asList(1, 2)));
        assertNull(NumberUtils.add(Arrays.asList(1, 2), null));
        assertNull(NumberUtils.add(null, null));
    }
    // test empty lists inputs
    @Test
    void testEmptyLists() {
        assertEquals(Arrays.asList(), NumberUtils.add(new LinkedList<>(), new LinkedList<>()));
        assertEquals(Arrays.asList(1), NumberUtils.add(new LinkedList<>(), Arrays.asList(1)));
        assertEquals(Arrays.asList(2), NumberUtils.add(Arrays.asList(2), new LinkedList<>()));
    }
    // test basic single digit adding
    @Test
    void testSingleDigits() {
        assertEquals(Arrays.asList(5), NumberUtils.add(Arrays.asList(2), Arrays.asList(3)));
        assertEquals(Arrays.asList(9), NumberUtils.add(Arrays.asList(4), Arrays.asList(5)));
        assertEquals(Arrays.asList(1, 0), NumberUtils.add(Arrays.asList(7), Arrays.asList(3)));
    }
    // test multiple digit num adding
    @Test
    void testMultiDigits() {
        assertEquals(Arrays.asList(6, 5), NumberUtils.add(Arrays.asList(2, 3), Arrays.asList(4, 2)));
        assertEquals(Arrays.asList(1, 0, 0), NumberUtils.add(Arrays.asList(4, 5), Arrays.asList(5, 5)));
    }
    // tests adding nums of diff lens
    @Test
    void testDifferentLengths() {
        assertEquals(Arrays.asList(1, 2, 3), NumberUtils.add(Arrays.asList(1, 2, 0), Arrays.asList(3)));
        assertEquals(Arrays.asList(1, 0, 0, 0), NumberUtils.add(Arrays.asList(9, 9, 9), Arrays.asList(1)));
    }
    // test nums that need carry over
    @Test
    void testWithCarry() {
        assertEquals(Arrays.asList(1, 0), NumberUtils.add(Arrays.asList(5), Arrays.asList(5)));
        assertEquals(Arrays.asList(2, 0, 0), NumberUtils.add(Arrays.asList(9, 9), Arrays.asList(1, 0, 1)));
    }
    // tests invalid digits throw exceptions
    @Test
    void testInvalidDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberUtils.add(Arrays.asList(10), Arrays.asList(1)));
        assertThrows(IllegalArgumentException.class, () ->
                NumberUtils.add(Arrays.asList(1), Arrays.asList(-1)));
    }
}