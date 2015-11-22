package co.edu.udea.runtwebapp.persistence.dao;

import java.util.List;

import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public interface IPersonDAO {
	
	public Person find(String documentType, String idNumber) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException;

	public Person findByCarriagePlate(String carriagePlate)throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException;

	public Person insert(Person person) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException;

	public Person update(Person person) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException;

	public List<Vehicle> getCarsByUser(String documentType, String idNumber) throws RuntWebAppDAOException;

	public List<Person> getAll() throws RuntWebAppDAOException;
}
