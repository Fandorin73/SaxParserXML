package ru.YLab.comporator;

import java.util.regex.Pattern;

public class FullComparator extends AbstractComparator {
    private Pattern pattern;
    @Override
    public void start() { }
    @Override
    public boolean compare(String context) {
        return true;
    }
}
