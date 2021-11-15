package ru.YLab.comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularComparatorTest {
    @Test
    public void regularComparatorTest() {
        AbstractComparator result=new RegularComparator();
        result.setMask(".*?[a-z]{4}-\\d+.[a-z]+");
        result.start();
        assertTrue(result.compare("file-9738721998.java"));
        assertFalse(result.compare("file.txt"));
        assertTrue(result.compare("file-222222224.txt"));
    }
}