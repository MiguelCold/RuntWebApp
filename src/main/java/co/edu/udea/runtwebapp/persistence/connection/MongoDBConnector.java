package co.edu.udea.runtwebapp.persistence.connection;

import java.net.UnknownHostException;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

/**
 * Clase que define la conexi&oacute;n a la base de datos MongoDB,
 * de manera que esta clase contiene todas configuraciones necesarias
 * para realizar dicha conexi&oacute;n, como la URL, el nombre de la
 * base de datos, el usuario y contraseña.
 * 
 * @author David Gomez
 * @author Farley R&uacute;a S&uacute;arez
 * @author Miguel &Aacute;ngel Ossa Ruiz
 */
public class MongoDBConnector {

	/**
	 * Atributo constante para realizar la gesti&oacute;n de la URL del
	 * servidor en donde se encuentra alojada la base de datos mongo..
	 */
	private static final String SERVER = "mongodb://admin:admin@ds051553.mongolab.com:51553/heroku_gv4dng9c";
	
	/**
	 * Atributo constante para realizar la gesti&oacute;n del nombre
	 * de la base de datos mongo.
	 */
	private static final String DATA_BASE_NAME = "heroku_gv4dng9c";

	/**
	 * Atributo para realizar la gesti&oacute;n del cliente
	 * a nivel de base de datos.
	 */
	private static MongoClient mongoClient;
	
	/**
	 * Atributo para realizar la gesti&oacute;n de la URI
	 * asociada al cliente de base de datos.
	 */
	private static MongoClientURI mongoClientURI;

	/**
	 * Constructor por defecto y sin par&aacute;metros para generar instancias
	 * de esta clase.
	 * <p>
	 * Este constructor realizar&aacute; una llamada expl&iacute;cita a su
	 * constructor padre.
	 */
	private MongoDBConnector() {
		super();
	}

	/**
	 * M&eacute;todo que permite realizar la conexi&oacute;n a la base
	 * de datos mongo, de manera que usa los atributos de la clase para
	 * hacer el llamado remoto y obtener la collecci&oacute;n pedida.
	 * 
	 * @param collectionName
	 * 				Variable de tipo String que especifica el nombre de
	 * 				la collecci&oacute; que se desea obtener.
	 * @return
	 * 				Instancia de la clase DBCollection que representa
	 * 				la colecci&oacute;n que se desea obtener.
	 * @throws UnknownHostException 
	 * 
	 */
	public static DBCollection connect(String collectionName)
			throws RuntWebAppTechnicalException, UnknownHostException {
		try {
			mongoClientURI = new MongoClientURI(SERVER);
			mongoClient = new MongoClient(mongoClientURI);

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
									+ " a la base de datos o al tratar de obtener la respectiva coleccion.\n%s",
							MongoDBConnector.class.getSimpleName(),
							"connect()", e));
		}
	}
}