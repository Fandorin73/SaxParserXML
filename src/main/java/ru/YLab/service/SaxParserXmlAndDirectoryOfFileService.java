package ru.YLab.service;

import ru.YLab.entity.FileAndDirectory;
import ru.YLab.model.SaxParserHandler;
import ru.YLab.model.SearchFile;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParserXmlAndDirectoryOfFileService {
    public void showFileDirectory(String pathOfFile, String searchingFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        SearchFile searchFile = new SearchFile();
        try {
            parser = factory.newSAXParser();
            File file = new File(pathOfFile);
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e.toString());
        }
        for (FileAndDirectory list : handler.getParsedfile()) {
            searchFile.showSearchingFile(searchingFile, list);
        }
    }
}
