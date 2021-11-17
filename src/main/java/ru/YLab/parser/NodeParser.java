package ru.YLab.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.YLab.comparator.AbstractComparator;


import static ru.YLab.constant.FileAndDirectoryParseConst.*;

public class NodeParser extends DefaultHandler {

    private String currentTagName;
    private AbstractComparator comparator;
    public void setComparator(AbstractComparator comparator) {
        this.comparator = comparator;
    }
    private Boolean isFile = false;
    private Boolean isDirectory = false;

    private boolean checkElement(Attributes attributes) { return attributes.getLength() > 0;}
    private boolean checkIsFile(Attributes attributes) { return attributes.getValue(IS_FILE).equals(TRUE); }
    private boolean checkIsIncludeNode(String currentTagName) { return currentTagName.equals(INCLUDE_NODE);}
    private boolean checkIsActiveNode(String currentTagName) {  return currentTagName.equals(ACTIVE_NODE); }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (checkElement(attributes)) {
            if (checkIsIncludeNode(currentTagName) && checkIsFile(attributes)) {
                isFile = true;
            }
            if (checkIsIncludeNode(currentTagName) && !checkIsFile(attributes)) {
                isDirectory = true;
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        comparator.removeDirectory(qName);
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
        if (isFile && checkIsActiveNode(currentTagName) && comparator.startComparator(content)) {
            comparator.printDirectory(content);
        }

        if (isDirectory && checkIsActiveNode(currentTagName)) {
            comparator.addToDirectory(content);
        }

    }
}
