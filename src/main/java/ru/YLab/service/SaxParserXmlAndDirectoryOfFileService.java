package ru.YLab.service;

import ru.YLab.entity.FileAndDirectory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParserXmlAndDirectoryOfFileService {
    public void showFileDirectory(String pathOfFile, String searchingFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        SearchFileService searchFile = new SearchFileService();
        try {
            parser = factory.newSAXParser();
            File file = new File(pathOfFile);
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e.toString());
        }
        for (FileAndDirectory list : handler.getParsedfile()) {
            searchFile.showFileFromString(searchingFile, list);
        }
    }
}
