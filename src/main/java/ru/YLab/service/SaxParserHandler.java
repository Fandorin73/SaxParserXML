package ru.YLab.service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.YLab.entity.FileAndDirectory;


import java.util.ArrayList;
import java.util.List;

import static ru.YLab.constant.FileAndDirectoryParseConst.TAG_CHILD;
import static ru.YLab.constant.FileAndDirectoryParseConst.TAG_CHILDREN;
import static ru.YLab.constant.FileAndDirectoryParseConst.TAG_NAME;

public class SaxParserHandler extends DefaultHandler {

    private String currentTagName;
    List<FileAndDirectory> listOfFiles = new ArrayList<>();

    //переменные для проверки, isFile являеться ли файлом или isDirectory директорией
    private Boolean isFile = false;
    private Boolean isDirectory = false;

    ArrayList<String> directoryString = new ArrayList<>();
    private String resultString;

    public List<FileAndDirectory> getParsedfile() {
        return listOfFiles;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (currentTagName.equals(TAG_CHILD) && attributes.getValue("is-file").equals("true")) {
            isFile = true;
        }
        if (currentTagName.equals(TAG_CHILD) && attributes.getValue("is-file").equals("false")) {
            isDirectory = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (directoryString.size() != 1 && qName.equals(TAG_CHILDREN)) {
            directoryString.remove(directoryString.size() - 1);
        }
        currentTagName = null;
        isFile = false;
        isDirectory = false;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) {
            return;
        }
        if (isFile && currentTagName.equals(TAG_NAME)) {
            for (String str : directoryString) {
                resultString += str;
            }
            listOfFiles.add(new FileAndDirectory(new String(ch, start, length), resultString));
            resultString = "";
        }

        if (isDirectory && currentTagName.equals(TAG_NAME)) {
            directoryString.add(new String(ch, start, length) + '/');
        }

    }
}
