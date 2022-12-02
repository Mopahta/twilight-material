package by.mopahta.task01.service;

import java.util.ArrayList;

import by.mopahta.task01.entity.Appliance;
import by.mopahta.task01.entity.criteria.Criteria;

public interface ApplianceService {

	ArrayList<Appliance> find(Criteria criteria);

	Appliance findLowestCostAppliance();

}