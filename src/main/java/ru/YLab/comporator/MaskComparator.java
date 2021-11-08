package ru.YLab.comporator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskComparator extends AbstractComparator {
    private Pattern pattern;

    @Override
    public void start() {
       String newMask=resultMask(getMask());
       pattern =Pattern.compile(newMask);
    }
    public String resultMask(String mask){
        StringBuilder newMask = new StringBuilder();
        char[] chars =mask.toCharArray();
        for (char ch:chars) {
            switch (ch){
                case'.':newMask.append("\\."); break;
                case'?':newMask.append("."); break;
                case'*':newMask.append(".*"); break;
                default:newMask.append(ch); break;
            }
        }
        return newMask.toString();
    }
    @Override
    public boolean compare(String context) {
        Matcher m= pattern.matcher(context);
        return m.matches();
    }
}
