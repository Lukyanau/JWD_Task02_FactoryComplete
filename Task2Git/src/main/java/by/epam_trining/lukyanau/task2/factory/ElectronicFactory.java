package by.epam_trining.lukyanau.task2.factory;

import by.epam_trining.lukyanau.task2.criteria.Criteria;
import by.epam_trining.lukyanau.task2.criteria.SearchCriteria;
import by.epam_trining.lukyanau.task2.entity.*;
import by.epam_trining.lukyanau.task2.entity.Laptop;
import by.epam_trining.lukyanau.task2.entity.Oven;
import by.epam_trining.lukyanau.task2.entity.Phone;
import by.epam_trining.lukyanau.task2.entity.Refrigerator;
import by.epam_trining.lukyanau.task2.entity.TabletPC;
import by.epam_trining.lukyanau.task2.entity.VacuumCleaner;
import by.epam_trining.lukyanau.task2.exception.ProjectException;

import java.util.Map;

public class ElectronicFactory {
    private static final ElectronicFactory instance = new ElectronicFactory();

    private ElectronicFactory() {
    }

    public static ElectronicFactory getInstance() {
        return instance;
    }

    public ElectronicDevice createDevice(ElectronicDeviceType electronicDeviceType, Map<String,String> parameters) throws ProjectException {
        ElectronicDevice electronicDevice;
        switch (electronicDeviceType) {
            case OVEN:
                electronicDevice = new Oven(Integer.parseInt(parameters.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Oven.WEIGHT.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Oven.CAPACITY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Oven.DEPTH.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Oven.HEIGHT.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Oven.WIDTH.toString())));
                break;
            case PHONE:
                electronicDevice = new Phone(Integer.parseInt(parameters.get(SearchCriteria.Phone.BATTERY_CAPACITY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Phone.ROM_MEMORY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Phone.SYSTEM_MEMORY.toString())),
                        Phone.ColorType.valueOf(parameters.get(SearchCriteria.Phone.COLOR.toString())));
                break;
            case LAPTOP:
                electronicDevice = new Laptop(Double.parseDouble(parameters.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())),
                        Laptop.TypeOS.valueOf(parameters.get(SearchCriteria.Laptop.OS.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Laptop.ROM_MEMORY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())),
                        Double.parseDouble(parameters.get(SearchCriteria.Laptop.CPU.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Laptop.DISPLAY_INCH.toString())));
                break;
            case TABLET_PC:
                electronicDevice = new TabletPC(Integer.parseInt(parameters.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.TabletPC.DISPLAY_INCH.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.TabletPC.ROM_MEMORY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())),
                        TabletPC.ColorType.valueOf(parameters.get(SearchCriteria.TabletPC.COLOR.toString())));
                break;
            case REFRIGERATOR:
                electronicDevice = new Refrigerator(Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.WEIGHT.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.HEIGHT.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.Refrigerator.WIDTH.toString())));
                break;
            case VACUUM_CLEANER:
                electronicDevice = new VacuumCleaner(Integer.parseInt(parameters.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())),
                        VacuumCleaner.TypeFilter.valueOf(parameters.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())),
                        Integer.parseInt(parameters.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())));
                break;
            default:
                throw new ProjectException("Illegal type of electronicDevice");
        }
        return electronicDevice;
    }
}
