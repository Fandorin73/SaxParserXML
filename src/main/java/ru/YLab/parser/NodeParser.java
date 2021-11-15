package ru.YLab.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.YLab.comporator.AbstractComparator;


import java.util.ArrayList;
import java.util.List;

import static ru.YLab.constant.FileAndDirectoryParseConst.*;

public class NodeParser extends DefaultHandler {

    private String currentTagName;
    private AbstractComparator comparator;

    public void setComparator(AbstractComparator comparator) {
        this.comparator = comparator;
    }

    //переменные для проверки, isFile являеться ли файлом или isDirectory директорией
    private Boolean isFile = false;
    private Boolean isDirectory = false;

    List<String> directory = new ArrayList<>();
    private String resultString = SPLIT_DIR;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (currentTagName.equals(INCLUDE_NODE) && attributes.getValue(IS_FILE).equals(TRUE)) {
            isFile = true;
        }
        if (currentTagName.equals(INCLUDE_NODE) && !attributes.getValue(IS_FILE).equals(TRUE)) {
            isDirectory = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (directory.size() != 1 && qName.equals(TAG_CHILDREN)) {
            directory.remove(directory.size() - 1);
        }
        currentTagName = null;
        isFile = false;
        isDirectory = false;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (currentTagName == null) {
            return;
        }
        if (isFile && currentTagName.equals(ACTIVE_NODE) && comparator.startComparator(content)) {
            for (String str : directory) {
                resultString += str;
            }
            System.out.println(resultString + content);
            resultString = "";
        }

        if (isDirectory && currentTagName.equals(ACTIVE_NODE)) {
            directory.add(content + SPLIT_DIR);
        }

    }
}
