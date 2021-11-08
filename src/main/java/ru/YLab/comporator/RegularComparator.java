package ru.YLab.comporator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularComparator extends AbstractComparator {
    Pattern pattern;
    @Override
    public void start() {
        pattern = Pattern.compile(getMask());
    }
    @Override
    public boolean compare(String context) {
        Matcher m= pattern.matcher(context);
        return m.matches();
    }
}