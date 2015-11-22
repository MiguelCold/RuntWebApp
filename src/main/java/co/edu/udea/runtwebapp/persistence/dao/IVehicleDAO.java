package co.edu.udea.runtwebapp.persistence.dao;

import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public interface IVehicleDAO {
	
	public Vehicle find(String carriagePlate)throws RuntWebAppDAOException,
	RuntWebAppPersistenceBusinessException;

}
