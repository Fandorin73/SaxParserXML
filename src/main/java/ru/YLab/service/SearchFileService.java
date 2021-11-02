package ru.YLab.service;

import ru.YLab.entity.FileAndDirectory;
import ru.YLab.exception.ArgumentException;

public class SearchFileService {

    private Boolean getResult = false;

    public void showFileFromString(String searchingFile, FileAndDirectory list) {
        if (searchingFile.equals(list.getName())) {
            getResult = true;
            System.out.println(list);
        } else if (!getResult && list.getName().matches("." + searchingFile)) {
            System.out.println(list);
            getResult = true;
        } else if (!getResult && searchingFile.equals("")) {
            System.out.println(list);
        }
    }


    public void showSearchingFile(String[] args) {
        SaxParserXmlAndDirectoryOfFileService parser = new SaxParserXmlAndDirectoryOfFileService();
        //Проверяем формат запроса и вызываем сервис который анализирует xml файл и выводит искомую директорию(и)
        try {
            if (args[0].equals("-f") & args[2].equals("-s")) {
                {
                    parser.showFileDirectory(args[1], args[3]);
                }
            } else
                throw new ArgumentException("Не верный формат, напишите в формате: $ java -jar assignment.jar -f <xml_file> -s <input> " + args[1] + " " + args[3]);
        } catch (Exception e) {
            if (args[0].equals("-f")) {
                {
                    parser.showFileDirectory(args[1], "");
                }
            } else
                throw new ArgumentException("Не верный формат, напишите в формате: $ java -jar assignment.jar -f <xml_file> -s <input> " + args[0]);
        }
    }
}
