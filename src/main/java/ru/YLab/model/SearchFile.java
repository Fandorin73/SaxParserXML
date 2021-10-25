package ru.YLab.model;

import ru.YLab.entity.FileAndDirectory;

public class SearchFile {
    public void showSearchingFile(String searchingFile, FileAndDirectory list) {

        if (searchingFile.equals(list.getName())) System.out.println(list);

        else if (list.getName().matches(searchingFile)) System.out.println(list);
        else if (searchingFile.equals("")) System.out.println(list);

    }
}
