package ru.YLab.comparator;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

import static ru.YLab.constant.FileAndDirectoryParseConst.*;

public class ComparatorProcess {

    private String mask;

    private List<String> directory = new ArrayList<>();
    private String resultString = SPLIT_DIR;

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void removeDirectory(String qName) {
        if (directory.size() != 1 && qName.equals(TAG_CHILDREN)) {
            directory.remove(directory.size() - 1);
        }
    }

    public void printDirectory(String content) {
        for (String str : directory) {
            resultString += str;
        }
        System.out.println(resultString + content);
        resultString = "";
    }

    public void addToDirectory(String content) {
        directory.add(content + SPLIT_DIR);
    }
}
