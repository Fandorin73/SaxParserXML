package ru.YLab.comporator;

import ru.YLab.constant.ComparatorTypeConst;


public class FactoryBuilderParser {
    public static AbstractComparator createComparator(ComparatorTypeConst type) {
        switch (type) {
            case Full:
                return new FullComparator();
            case Eqals:
                return new EqalsComparator();
            case Mask:
                return new MaskComparator();
            case Regular:
                return new RegularComparator();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
