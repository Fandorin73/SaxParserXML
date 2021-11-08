package ru.YLab;

import ru.YLab.argument.ArgumentProcess;
import ru.YLab.comporator.AbstractComparator;
import ru.YLab.comporator.FactoryBuilderParser;
import ru.YLab.exception.ArgumentException;
import ru.YLab.parser.SaxParser;

public class Main {
    public static void main(String[] args) {
        try{
            ArgumentProcess argumentProcess=new ArgumentProcess(args);
            FactoryBuilderParser factoryBuilderParser=new FactoryBuilderParser();
            AbstractComparator comparator=factoryBuilderParser.createComparator(argumentProcess.getType());
            comparator.setMask(argumentProcess.getMask());
            new SaxParser(comparator,argumentProcess.getInputFileName());
        }
        catch (Exception e){
            throw new ArgumentException("Not file or incorrect mask"+ e);
        }
    }
}
