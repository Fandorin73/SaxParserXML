package ru.YLab.comparator;

public abstract class AbstractComparator extends ComparatorMask {

    public abstract void start();

    public abstract boolean compare(String context);

    public Boolean startComparator(String context) {
        start();
        return compare(context);
    }
}
