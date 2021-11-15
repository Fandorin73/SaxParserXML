package ru.YLab;

import ru.YLab.argument.ArgumentProcess;
import ru.YLab.comporator.AbstractComparator;
import ru.YLab.comporator.FactoryBuilderParser;
import ru.YLab.exception.ArgumentException;
import ru.YLab.parser.SaxParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            ArgumentProcess argumentProcess = new ArgumentProcess(args);
            FactoryBuilderParser factoryBuilderParser = new FactoryBuilderParser();
            AbstractComparator comparator = factoryBuilderParser.createComparator(argumentProcess.getType());
            comparator.setMask(argumentProcess.getMask());
            new SaxParser(comparator, argumentProcess.getInputFileName());

        } catch (ArgumentException e) {
            System.out.println("Not file or incorrect mask" + e);
            return;
        } catch (Exception e) {
            System.out.println("Not file or incorrect mask" + e);
        }

    }
}
