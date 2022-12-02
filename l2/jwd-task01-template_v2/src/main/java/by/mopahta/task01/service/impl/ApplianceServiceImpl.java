package by.mopahta.task01.service.impl;

import java.util.ArrayList;

import by.mopahta.task01.dao.ApplianceDAO;
import by.mopahta.task01.dao.DAOFactory;
import by.mopahta.task01.entity.Appliance;
import by.mopahta.task01.entity.ApplianceFactory;
import by.mopahta.task01.entity.AppliancePriceComparator;
import by.mopahta.task01.entity.criteria.Criteria;
import by.mopahta.task01.entity.criteria.SearchCriteria;
import by.mopahta.task01.service.ApplianceService;
import by.mopahta.task01.service.validation.Validator;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService{

	public ArrayList<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		ArrayList<ArrayList<String>> applianceInfos = applianceDAO.find(criteria.getGroupSearchName());
		ApplianceFactory applianceFactory = new ApplianceFactory();
		ArrayList<Appliance> appliances = new ArrayList<>();

		for (ArrayList<String> applianceInfo : applianceInfos) {
			Appliance appliance = applianceFactory.createInstance(criteria.getGroupSearchName(), applianceInfo);
			if (isMeetsCriteria(appliance, criteria)) {
				appliances.add(appliance);
			}
		}
		return appliances;
	}

	private boolean isMeetsCriteria(Appliance appliance, Criteria criteria){
		for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
			if (!appliance.getFieldByName(entry.getKey()).equals(entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public Appliance findLowestCostAppliance() {
		ArrayList<Appliance> appliances = new ArrayList<>();
		appliances.addAll(find(new Criteria(SearchCriteria.Laptop.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Oven.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Refrigerator.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Speakers.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.TabletPC.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName())));

		appliances.sort(new AppliancePriceComparator());//

		return appliances.get(0);
	}

}


