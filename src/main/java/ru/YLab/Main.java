package ru.YLab;


import ru.YLab.service.SaxParserXmlAndDirectoryOfFileService;

public class Main {
    public static void main(String[] args) {
        SaxParserXmlAndDirectoryOfFileService parser = new SaxParserXmlAndDirectoryOfFileService();
        //Проверяем формат запроса и вызываем сервис который анализирует xml файл и выводит искомую директорию(и)
        try {
            if (args[0].equals("-f") & args[2].equals("-s") )
                parser.showFileDirectory(args[1], args[3]);
            else
                System.out.println("Не верный формат, напишите в формате: $ java -jar assignment.jar -f <xml_file> -s <input>");
        } catch (Exception e) {
            if (args[0].equals("-f"))
                parser.showFileDirectory(args[1], "");
            else
                System.out.println("Не верный формат, напишите в формате: $ java -jar assignment.jar -f <xml_file> -s <input>");
        }


    }
}
