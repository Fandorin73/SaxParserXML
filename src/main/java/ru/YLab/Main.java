package ru.YLab;

import ru.YLab.service.SearchFileService;

public class Main {
    public static void main(String[] args) {
        SearchFileService searchFileService = new SearchFileService();
        searchFileService.showSearchingFile(args);
    }
}
