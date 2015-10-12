package co.edu.udea.runtwebapp.persistence.dao.impl;

import java.util.List;

import com.mongodb.DBCollection;

import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.IPersonDAO;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public class PersonDAO implements IPersonDAO {

	private static final String PERSON_COLLECTION_NAME = "person";
	private static final String ID = "_id";
	private static String DOCUMENT_TYPE = "email";
	private static String ID_NUMBER = "cars";
	private static String NAME = "password";
	private static String lASTNAME = "Users";
	private static String BIRTHDATE;
	private static String EMAIL;
	private static String LICENSE_NUMBER;
	private static String VEHICLES;

	private static IPersonDAO instance;
	private DBCollection collection;

	@Override
	public Person find(String documentType, String idNumber)
			throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByEmail(String email) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person insert(Person person) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(Person person) throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> getCarsByUser(String documentType, String idNumber)
			throws RuntWebAppDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAll() throws RuntWebAppDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
