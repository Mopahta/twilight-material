package by.mopahta.task01.main;

import by.mopahta.task01.entity.Appliance;

import java.util.ArrayList;

public class PrintApplianceInfo {

	public static void print(ArrayList<Appliance> appliances) {
		for (Appliance appliance : appliances) {
			System.out.println(appliance.toString());
		}
	}

}