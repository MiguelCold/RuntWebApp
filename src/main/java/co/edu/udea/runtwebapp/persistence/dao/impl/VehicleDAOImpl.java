package co.edu.udea.runtwebapp.persistence.dao.impl;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.connection.MongoDBConnector;
import co.edu.udea.runtwebapp.persistence.dao.IVehicleDAO;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public class VehicleDAOImpl implements IVehicleDAO {

	private static final String VEHICLE_COLLECTION_NAME = "vehicle";
	private static String CARRIAGE_PLATE = "carriage_plate";
	private static IVehicleDAO instance;
	private DBCollection collection;
	
	private VehicleDAOImpl() throws RuntWebAppTechnicalException, UnknownHostException{
		super();
		this.collection = MongoDBConnector.connect(VEHICLE_COLLECTION_NAME);
	}
	
	public static synchronized IVehicleDAO getInstance()
			throws RuntWebAppTechnicalException, UnknownHostException {
		if(instance == null){
			instance = new VehicleDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Vehicle find(String carriagePlate) 
			throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException {
		try {
			
			if (null == carriagePlate || carriagePlate.trim().isEmpty() ||
					("").equals(carriagePlate.trim())) {
				throw new RuntWebAppPersistenceBusinessException(String.format(
						"Clase %s: método %s. El parámetro carriagePlate de tipo %s"
								+ " no puede ser nulo ni vacío.",
								VehicleDAOImpl.class.getSimpleName(), "find",
						String.class.getSimpleName()));
			}else{
				BasicDBObject query = new BasicDBObject();
				query.put(CARRIAGE_PLATE, carriagePlate);
				DBObject dbObject = this.collection.findOne(query);

				return (dbObject == null) ? null : 
					Vehicle.entityFromDBObject(dbObject);
			}
			
		}catch(Exception e) {
			throw new RuntWebAppDAOException(
					String.format(
							"Clase %s: método %s. Se presentó un error inesperado.\n%s",
							VehicleDAOImpl.class.getSimpleName(),
							"find", e));
		}
	}

}
