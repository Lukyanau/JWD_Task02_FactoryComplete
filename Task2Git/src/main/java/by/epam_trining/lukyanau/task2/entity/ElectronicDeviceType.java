package by.epam_trining.lukyanau.task2.entity;

import java.util.HashMap;
import java.util.Map;

public enum ElectronicDeviceType {
    LAPTOP("Laptop"),
    OVEN("Oven"),
    PHONE("Phone"),
    REFRIGERATOR("Refrigerator"),
    TABLET_PC("TabletPC"),
    VACUUM_CLEANER("VacuumCleaner");

    private final String electronicType;

    ElectronicDeviceType(String electronicType) {
        this.electronicType = electronicType;
    }

    public String getElectronicType() {
        return electronicType;
    }

    private static final Map<String, ElectronicDeviceType> LOOKUP_MAP = new HashMap<>();

    static {
        for (ElectronicDeviceType element : values()) {
            LOOKUP_MAP.put(element.getElectronicType(), element);
        }
    }

    public static ElectronicDeviceType getRoleByName(String name) {
        return LOOKUP_MAP.get(name);
    }

}