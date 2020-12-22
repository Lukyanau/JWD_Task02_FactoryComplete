package by.epam_trining.lukyanau.task2.reader;

import by.epam_trining.lukyanau.task2.exception.ProjectException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderRunner {

    public List<String> getFileData() throws ProjectException {
        Path file = Paths.get("resources/data.txt");
        List<String> lines;
        try {
             lines = Files.readAllLines(file);
        } catch (IOException exp) {
            throw new ProjectException("Error while opening file:" + file.toString(), exp);
        }
        return lines;
    }
}
