package by.mopahta.task01.entity;

import java.util.ArrayList;

public class VacuumCleaner extends Appliance{
    //POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
    private int powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner(int powerConsumption, String filterType, String bagType, String wandType, int motorSpeedRegulation, int cleaningWidth, int price) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
        this.setPrice(price);
    }

    public static VacuumCleaner createInstance(ArrayList<String> params) {
        return new VacuumCleaner(
                Integer.parseInt(params.get(0)),
                params.get(1),
                params.get(2),
                params.get(3),
                Integer.parseInt(params.get(4)),
                Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6))
        );
    }

    public Object getFieldByName(String name){
        return switch (name) {
            case "POWER_CONSUMPTION" -> powerConsumption;
            case "FILTER_TYPE" -> filterType;
            case "BAG_TYPE" -> bagType;
            case "WAND_TYPE" -> wandType;
            case "MOTOR_SPEED_REGULATION" -> motorSpeedRegulation;
            case "CLEANING_WIDTH" -> cleaningWidth;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                ", price=" + getPrice() +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    // you may add your own code here
}
