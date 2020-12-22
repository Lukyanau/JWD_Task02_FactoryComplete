package by.epam_trining.lukyanau.task2.criteria;

public final class SearchCriteria {
    public  enum Oven {
        POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
    }

    public  enum Laptop {
        BATTERY_CAPACITY, OS, ROM_MEMORY, SYSTEM_MEMORY, CPU, DISPLAY_INCH
    }

    public  enum Phone {
        BATTERY_CAPACITY, ROM_MEMORY, SYSTEM_MEMORY, COLOR
    }

    public  enum Refrigerator {
        POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
    }

    public  enum TabletPC {
        BATTERY_CAPACITY, DISPLAY_INCH, ROM_MEMORY, FLASH_MEMORY_CAPACITY, COLOR
    }

    public  enum VacuumCleaner {
        POWER_CONSUMPTION, FILTER_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
    }
}
