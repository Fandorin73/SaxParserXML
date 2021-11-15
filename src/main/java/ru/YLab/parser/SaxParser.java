package ru.YLab.parser;

import ru.YLab.comparator.AbstractComparator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {
    public SaxParser(AbstractComparator comparator, String pathOfFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        NodeParser handler = new NodeParser();
        SAXParser parser;
        handler.setComparator(comparator);
        try {
            parser = factory.newSAXParser();
            File file = new File(pathOfFile);
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e.toString());
        }
    }
}
