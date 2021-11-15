package ru.YLab.comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaskComparatorTest {
    @Test
    public void maskComparatorTest() {
        AbstractComparator result=new MaskComparator();
        result.setMask("*.java");
        result.start();
        assertTrue(result.compare("file-847675734.java"));
        assertFalse(result.compare("file-847675734.jav"));
        assertFalse(result.compare("file-222222224.txt"));

    }
}