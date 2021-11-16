package ru.YLab.comparator;

import org.junit.jupiter.api.Test;
import ru.YLab.comparator.AbstractComparator;
import ru.YLab.comparator.FullComparator;

import static org.junit.jupiter.api.Assertions.*;

class FullComparatorTest {
    @Test
    public void fullComparatorTest() {
        AbstractComparator result = new FullComparator();
        assertTrue(result.compare("file-1111.txt"));
    }

}