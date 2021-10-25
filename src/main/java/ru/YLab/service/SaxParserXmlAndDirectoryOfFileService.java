package ru.YLab.service;

import org.xml.sax.SAXException;
import ru.YLab.entity.FileAndDirectory;
import ru.YLab.model.SaxParserHandler;
import ru.YLab.model.SearchFile;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class SaxParserXmlAndDirectoryOfFileService {
    public void showFileDirectory(String pathOfFile, String searchingFile) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        SearchFile searchFile = new SearchFile();
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e.toString());
        }
        File file = new File(pathOfFile);
        try {
            parser.parse(file, handler);

        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());

        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());

        }

        for (FileAndDirectory list : handler.getParsedfile()) {
            searchFile.showSearchingFile(searchingFile, list);
        }


    }
}
