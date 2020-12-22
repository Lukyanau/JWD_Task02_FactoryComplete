package by.epam_trining.lukyanau.task2.parser;

import by.epam_trining.lukyanau.task2.criteria.Criteria;
import by.epam_trining.lukyanau.task2.exception.ProjectException;
import by.epam_trining.lukyanau.task2.reader.ReaderRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    public static List<String> getNecessaryLines(Criteria criteria) throws ProjectException {
        ReaderRunner readerRunner = new ReaderRunner();
        List<String> lines = readerRunner.getFileData();
        List<String> necessaryLines = new ArrayList<>();
        Pattern pattern = Pattern.compile(criteria.getGroupSearchName());
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                necessaryLines.add(line);
                //System.out.println(line);
            }

        }
        return necessaryLines;
    }
}
