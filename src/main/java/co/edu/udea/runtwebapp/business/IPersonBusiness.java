package co.edu.udea.runtwebapp.business;

import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.model.entities.Person;

public interface IPersonBusiness {
	
	public Person find(String documentType, String idNumber) throws RuntWebAppBusinessException;

	public Person findByCarriagePlate(String carriagePlate) throws RuntWebAppBusinessException;

}
