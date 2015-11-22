package co.edu.udea.runtwebapp.business;

import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.model.entities.Vehicle;

public interface IVehicleBusiness {
	
	public Vehicle find(String carriagePlate) throws RuntWebAppBusinessException;

}
