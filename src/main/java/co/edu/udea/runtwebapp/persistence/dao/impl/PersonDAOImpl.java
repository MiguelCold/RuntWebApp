package co.edu.udea.runtwebapp.persistence.dao.impl;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.connection.MongoDBConnector;
import co.edu.udea.runtwebapp.persistence.dao.IPersonDAO;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public class PersonDAOImpl implements IPersonDAO {

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
	
	private PersonDAOImpl() throws RuntWebAppTechnicalException, UnknownHostException{
		super();
		this.collection = MongoDBConnector.connect(PERSON_COLLECTION_NAME);
	}
	
	public static synchronized IPersonDAO getInstance()
			throws RuntWebAppTechnicalException, UnknownHostException {
		if (null == instance) {
			instance = new PersonDAOImpl();
		}

		return instance;
	}

	@Override
	public Person find(String documentType, String idNumber)
			throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		try {
			if (null == documentType || ("").equals(documentType.trim()) || null == idNumber
					|| ("").equals(idNumber.trim())) {
				throw new RuntWebAppPersistenceBusinessException(String.format(
						"Clase %s: método %s. Los parámetros documentType o idNumber (ambos de tipo %s) "
								+ "no pueden ser ni nulos ni vacíos.",
								PersonDAOImpl.class.getSimpleName(), "find",
						String.class.getSimpleName()));
			} else {
				BasicDBObject projection = new BasicDBObject(ID_NUMBER, 0);
				BasicDBObject query = new BasicDBObject();
				query.put(DOCUMENT_TYPE, documentType);
				query.put(ID_NUMBER, idNumber);
				DBObject dbObject = this.collection.findOne(query, projection);

				return (dbObject == null) ? null : Person
						.entityFromDBObject(dbObject);
			}
		} catch (Exception e) {
			throw new RuntWebAppDAOException(
					String.format(
							"Clase %s: método %s. Se presentó un error inesperado.\n%s",
							PersonDAOImpl.class.getSimpleName(),
							"findByEmailAndPassword", e));
		}
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
