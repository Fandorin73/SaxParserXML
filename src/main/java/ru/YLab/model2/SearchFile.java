package ru.YLab.model2;

import ru.YLab.entity.FileAndDirectory;

public class SearchFile {
    public void showSearchingFile(String searchingFile, FileAndDirectory list) {

        if (searchingFile.equals(list.getName())) System.out.println(list);

       /* if (searchingFile.equals(list.getName())) return list;
        if (searchingFile.equals(null)) return list;

            *//* else if(searchingFile.equals("(.*)java")list.getName().matches("(.*)java")) return list;*//*
            *//*     if(list.getName().matches(".*?[a-z]{4}-\d+\.[a-z]+")) return list;*//*

            *//*   else if(searchingFile==('.*?[a-z]{4}-\d+\.[a-z]+')) System.out.println("Верно");*//*
        else return null;*/
    }
}
