package ru.YLab.comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullComparatorTest {
    @Test
    public void fullComparatorTest() {
        AbstractComparator result = new FullComparator();
        assertTrue(result.compare("file-1111.txt"));
    }

}