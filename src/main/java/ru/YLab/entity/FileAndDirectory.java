package ru.YLab.entity;

public class FileAndDirectory {
    // Файл и директроия где он находиться

    private String name;
    private String directory;

    public FileAndDirectory(String name, String directory) {
        this.name = name;
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public String getDirectory() {
        return directory;
    }

    @Override
    public String toString() {
        if (directory == null)
            return "/" + name;
        else
            return "/" + directory + name;
    }
}
