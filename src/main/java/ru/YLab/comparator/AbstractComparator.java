package ru.YLab.comparator;

public abstract class AbstractComparator extends ComparatorProcess {

    public abstract void start();

    public abstract boolean compare(String context);

    public Boolean startComparator(String context) {
        start();
        return compare(context);
    }
}
