package by.mopahta.task01.main;

import static by.mopahta.task01.entity.criteria.SearchCriteria.*;

import by.mopahta.task01.entity.Appliance;
import by.mopahta.task01.entity.criteria.Criteria;
import by.mopahta.task01.service.ApplianceService;
import by.mopahta.task01.service.ServiceFactory;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
		//criteriaOven.add(Oven.WEIGHT.toString(), 5);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		System.out.println("Самый дешевый товар: " + service.findLowestCostAppliance());

	}

}