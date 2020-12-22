package by.epam_trining.lukyanau.task2.service;

import by.epam_trining.lukyanau.task2.criteria.Criteria;
import by.epam_trining.lukyanau.task2.entity.ElectronicDevice;
import by.epam_trining.lukyanau.task2.exception.ProjectException;

import java.util.List;

public interface ElectronicService {
    List<ElectronicDevice> find(Criteria criteria) throws ProjectException;
}
