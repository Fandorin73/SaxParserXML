package ru.YLab.comparator;

import org.junit.jupiter.api.Test;
import ru.YLab.Main;
import ru.YLab.comparator.AbstractComparator;
import ru.YLab.comparator.EqalsComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EqalsComparatorTest {
    @Test
    public void eqalsComparatorTest() {
        AbstractComparator result = new EqalsComparator();
        result.setMask("file-847675734.xhtml");
        assertTrue(result.compare("file-847675734.xhtml"));
    }
}