package by.mopahta.task01.entity;

import java.util.ArrayList;

public class TabletPC extends Appliance{
    //BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, FLASH_MEMORY_CAPACITY, COLOR
    private int batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC(int batteryCapacity, int displayInches, int memoryRom, int flashMemoryCapacity, String color, int price) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
        this.setPrice(price);
    }

    public static ArrayList<TabletPC> createInstances(ArrayList<ArrayList<String>> params) {
        ArrayList<TabletPC> appliances = new ArrayList<>();
        for (ArrayList<String> currParams : params) {
            appliances.add(new TabletPC(
                    Integer.parseInt(currParams.get(0)),
                    Integer.parseInt(currParams.get(1)),
                    Integer.parseInt(currParams.get(2)),
                    Integer.parseInt(currParams.get(3)),
                    currParams.get(4),
                    Integer.parseInt(currParams.get(5))
            ));
        }
        return appliances;
    }

    public static TabletPC createInstance(ArrayList<String> params) {
        return new TabletPC(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)),
                Integer.parseInt(params.get(3)),
                params.get(4),
                Integer.parseInt(params.get(5))
        );
    }

    public Object getFieldByName(String name){
        return switch (name) {
            case "BATTERY_CAPACITY" -> batteryCapacity;
            case "DISPLAY_INCHES" -> displayInches;
            case "MEMORY_ROM" -> memoryRom;
            case "FLASH_MEMORY_CAPACITY" -> flashMemoryCapacity;
            case "COLOR" -> color;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // you may add your own code here
}
