package co.edu.udea.runtwebapp.persistence.connection;

import java.net.UnknownHostException;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

public class MongoDBConnector {

	private static final String SERVER = "mongodb://admin:admin@ds051553.mongolab.com:51553/heroku_gv4dng9c";
	
	private static final String DATA_BASE_NAME = "heroku_gv4dng9c";

	private static MongoClient mongoClient;
	
	private static MongoClientURI mongoClientURI;

	private MongoDBConnector() {
		super();
	}

	public static DBCollection connect(String collectionName)
			throws RuntWebAppTechnicalException, UnknownHostException {
		try {
			mongoClientURI = new MongoClientURI(SERVER);
			mongoClient = new MongoClient(mongoClientURI);

			@SuppressWarnings("deprecation")
			DB db = mongoClient.getDB(DATA_BASE_NAME);
			DBCollection collection = db.getCollection(collectionName);

			if (collection == null) {
				collection = db.createCollection(collectionName, null);
			}

			return collection;
		} catch (MongoException | NullPointerException e) {
			throw new RuntWebAppTechnicalException(
					String.format(
							"Clase %s: método %s. Se produjo una excepción al tratar de conectarse"
									+ " a la base de datos o al tratar de obtener la respectiva colección.\n%s",
							MongoDBConnector.class.getSimpleName(),
							"connect()", e));
		}
	}
}