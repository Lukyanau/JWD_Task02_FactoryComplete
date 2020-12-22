package by.epam_trining.lukyanau.task2.service;

import by.epam_trining.lukyanau.task2.criteria.Criteria;
import by.epam_trining.lukyanau.task2.entity.ElectronicDevice;
import by.epam_trining.lukyanau.task2.entity.ElectronicDeviceType;
import by.epam_trining.lukyanau.task2.exception.ProjectException;
import by.epam_trining.lukyanau.task2.factory.ElectronicFactory;
import by.epam_trining.lukyanau.task2.parser.DataParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElectronicServiceImpl implements ElectronicService {
    private static final String REGEX_COMPARE = "=";
    private static final String REGEX_DELIMITER = "+";
    private static final String REGEX_PARAMETERS = ", ";
    private static final String REGEX_SUB_LINE = ": ";

    @Override
    public List<ElectronicDevice> find(Criteria criteria) throws ProjectException {
        ElectronicFactory electronicFactory = ElectronicFactory.getInstance();

        String electronicType = criteria.getGroupSearchName();
        Set<Map.Entry<String, Object>> criteriaParameters = criteria.getEntries();
        List<String> necessaryLines = DataParser.getNecessaryLines(criteria);
        List<String> criteriaParametersRegex = createRegexParameters(criteriaParameters);
        List<String> foundedLines = getFoundedLines(necessaryLines, criteriaParametersRegex);

        List<ElectronicDevice> resultsElectronicDevice = new ArrayList<>();
        for (String foundedLine : foundedLines) {
            Map<String, String> parametersMap = createParametersForDevice(foundedLine, electronicType);
            resultsElectronicDevice.add(electronicFactory.createDevice(ElectronicDeviceType.getRoleByName(electronicType), parametersMap));
        }
        return resultsElectronicDevice;
    }

    public List<String> createRegexParameters(Set<Map.Entry<String, Object>> set) {
        List<String> regexParameters = new ArrayList<>();
        for (Map.Entry<String, Object> currentPair : set) {
            String newStringRegex = currentPair.getKey() + REGEX_COMPARE + currentPair.getValue().toString();
            regexParameters.add(newStringRegex);
        }
        return regexParameters;
    }

    public List<String> getFoundedLines(List<String> necessaryLines, List<String> criteriaParametersRegex) {
        List<String> foundedLines = new ArrayList<>();
        for (String line : necessaryLines) {
            boolean isCompared = true;
            for (String regexLine : criteriaParametersRegex) {
                Pattern pattern = Pattern.compile(regexLine + REGEX_DELIMITER);
                Matcher matcher = pattern.matcher(line);
                if (!matcher.find()) {
                    isCompared = false;
                    break;
                }
            }
            if (isCompared) {
                foundedLines.add(line);
            }
        }
        return foundedLines;
    }

    public Map<String, String> createParametersForDevice(String deviceLine, String electronicType) {
        Map<String, String> resultParameters = new HashMap<>();
        String parametersLine = deviceLine.replace(electronicType + REGEX_SUB_LINE, "");
        String[] parametersArray = parametersLine.split(REGEX_PARAMETERS);
        for (String line : parametersArray) {
            String[] arrayPair = line.split(REGEX_COMPARE);
            resultParameters.put(arrayPair[0], arrayPair[1]);
        }
        return resultParameters;
    }
}
