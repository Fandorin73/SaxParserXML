package ru.YLab.comparator;

public class EqalsComparator extends AbstractComparator {
    @Override
    public void start() {
    }
    @Override
    public boolean compare(String context) {
        return (getMask().equals(context));
    }
}
