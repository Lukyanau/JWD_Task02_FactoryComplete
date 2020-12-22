package by.epam_trining.lukyanau.task2.runner;

import by.epam_trining.lukyanau.task2.criteria.Criteria;
import by.epam_trining.lukyanau.task2.criteria.SearchCriteria;
import by.epam_trining.lukyanau.task2.entity.*;
import by.epam_trining.lukyanau.task2.exception.ProjectException;
import by.epam_trining.lukyanau.task2.service.ElectronicServiceImpl;

import java.util.List;

public class ElectronicFactoryRunner {
    public static void main(String[] args) throws ProjectException {
        List<ElectronicDevice> foundedDevices;

        Criteria criteria = new Criteria(Oven.class.getSimpleName());
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1500);
        ElectronicServiceImpl electronicService = new ElectronicServiceImpl();
        foundedDevices = electronicService.find(criteria);

        System.out.println(foundedDevices);

    }
}
