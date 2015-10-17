package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ServiceType implements Serializable {

	private static final long serialVersionUID = -5742524916570275343L;
	private static String ID = "_id";
	private static String CODE = "code";
	private static String DESCRIPTION = "description";
	
	private String id;
	private String code;
	private String description;

	public ServiceType() {
		super();
	}

	public ServiceType(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public static ServiceType entityFromDBObject(DBObject dbObject) {
		ServiceType serviceType = null;
		if (dbObject != null) {
			serviceType = new ServiceType();

			if (dbObject.containsField(ID)) {
				serviceType.setId(dbObject.get(ID).toString().trim());
			}

			if (dbObject.containsField(CODE)) {
				serviceType.setCode((String) dbObject.get(CODE));
			}

			if (dbObject.containsField(DESCRIPTION)) {
				serviceType.setDescription((String) dbObject.get(DESCRIPTION));
			}

		}

		return serviceType;
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

}
