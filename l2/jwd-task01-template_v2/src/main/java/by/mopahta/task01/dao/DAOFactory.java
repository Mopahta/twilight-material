package by.mopahta.task01.dao;

import by.mopahta.task01.dao.impl.FileApplianceDAOImpl;


public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new FileApplianceDAOImpl();
	
	private DAOFactory() {}

	/**
	 *
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
