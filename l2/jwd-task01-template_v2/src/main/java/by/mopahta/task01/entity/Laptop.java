package by.mopahta.task01.entity;

import java.util.ArrayList;

public class Laptop extends Appliance{
    //BATTERY_CAPACITY, OS, MEMORY_ROM, SYSTEM_MEMORY, CPU, DISPLAY_INCHS
    private int batteryCapacity;
    private int os;
    private int memoryRom;
    private int systemMemory;
    private int cpu;
    private int displayInches;

    public Laptop(int batteryCapacity, int os, int memoryRom, int systemMemory, int cpu, int displayInches, int price) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
        this.setPrice(price);
    }

    public static Laptop createInstance(ArrayList<String> params) {
        return new Laptop(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)),
                Integer.parseInt(params.get(3)),
                Integer.parseInt(params.get(4)),
                Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6))
        );
    }

    public Object getFieldByName(String name){
        return switch (name) {
            case "BATTERY_CAPACITY" -> batteryCapacity;
            case "OS" -> os;
            case "MEMORY_ROM" -> memoryRom;
            case "SYSTEM_MEMORY" -> systemMemory;
            case "CPU" -> cpu;
            case "DISPLAY_INCHS" -> displayInches;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os=" + os +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                ", price=" + getPrice() +
                '}';
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getOs() {
        return os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public int getCpu() {
        return cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    // you may add your own code here
}
