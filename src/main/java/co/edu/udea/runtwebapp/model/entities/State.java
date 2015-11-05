package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Clase que representa la entidad State del modelo, esta
 * entidad define los estados por los cuales pasa un 
 * veh&iacute;culo con sus respectivas fechas.
 * 
 * @author David Gomez
 * @author Farley R&uacute;a S&uacute;arez
 * @author Miguel &Aacute;ngel Ossa Ruiz
 */
@XmlAccessorType(value = XmlAccessType.PROPERTY)
@XmlRootElement()
public class State implements Serializable{

	private static final long serialVersionUID = -4404003904493640657L;
	private static String ID = "_id";
	private static String CODE = "code";
	private static String DESCRIPTION = "description";
	private static String START_DATE = "start_date";
	private static String END_DATE = "end_date";
	
	private String id;

	/**
	 * Atributo que representa el c&oacute;digo del estado.
	 */
	private String code;
	
	/**
	 * Atributo que describe el estado.
	 */
	private String description;
	
	/**
	 * Atributo que describe la fecha en la que se inici&oacute;.
	 */
	private Date startDate;
	
	/**
	 * Atributo que describe la fecha en la que se finaliz&oacute;.
	 */
	private Date endDate;

	/**
	 * Constructor vac&iacute;o de la clase que permite la creaci&oacute;n 
	 * de una nueva instancia de esta clase.
	 */
	public State() {
		super();
	}
	
	/**
	 * Constructor vac&iacute;o de la clase que permite la creaci&oacute;n 
	 * de una nueva instancia de esta clase.
	 * 
	 * @param code
	 * 			String que representa el c&oacute;digo del estado.
	 * 
	 * @param description
	 * 			String que representa la descripci&oacute;n del estado.
	 */
	public State(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public static State entityFromDBObject(DBObject dbObject) {
		State state = null;
		if (dbObject != null) {
			state = new State();

			if (dbObject.containsField(ID)) {
				state.setId(dbObject.get(ID).toString().trim());
			}

			if (dbObject.containsField(CODE)) {
				state.setCode((String) dbObject.get(CODE));
			}

			if (dbObject.containsField(DESCRIPTION)) {
				state.setDescription((String) dbObject.get(DESCRIPTION));
			}
			
			if (dbObject.containsField(START_DATE)) {
				state.setStartDate((Date) dbObject.get(START_DATE));
			}
			
			if (dbObject.containsField(END_DATE)) {
				state.setEndDate((Date) dbObject.get(END_DATE));
			}

		}

		return state;
	}

	public BasicDBObject entityToDBObject() {
		BasicDBObject basicDBObject = new BasicDBObject();

		if (null != this.getId() && !("").equals(this.getId().trim())) {
			basicDBObject.put(ID, new ObjectId(this.getId().trim()));
		}

		if (null != this.getCode()) {
			basicDBObject.put(CODE, this.getCode());
		}

		if (null != this.getDescription()) {
			basicDBObject.put(DESCRIPTION, this.getDescription());
		}
		
		if (null != this.getStartDate()) {
			basicDBObject.put(START_DATE, this.getStartDate());
		}
		
		if (null != this.getEndDate()) {
			basicDBObject.put(END_DATE, this.getEndDate());
		}
		
		return basicDBObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
