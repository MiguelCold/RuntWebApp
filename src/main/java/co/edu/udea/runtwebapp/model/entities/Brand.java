package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.mongodb.DBObject;

@XmlAccessorType(value = XmlAccessType.PROPERTY)
@XmlRootElement()
public class Brand implements Serializable{

	private static final long serialVersionUID = -809411911029084501L;
	private static String ID = "_id";
	private static String CODE = "code";
	private static String NAME = "name";
	
	private String id;
	private String code;
	private String name;

	public Brand() {
		super();
	}

	public Brand(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public static Brand entityFromDBObject(DBObject dbObject) {
		Brand brand = null;
		if (dbObject != null) {
			brand = new Brand();

			if (dbObject.containsField(ID)) {
				brand.setId(dbObject.get(ID).toString().trim());
			}

			if (dbObject.containsField(CODE)) {
				brand.setCode((String) dbObject.get(CODE));
			}

			if (dbObject.containsField(NAME)) {
				brand.setName((String) dbObject.get(NAME));
			}

		}

		return brand;
	}

//	public BasicDBObject entityToDBObject() {
//		BasicDBObject basicDBObject = new BasicDBObject();
//
//		if (null != this.getId() && !("").equals(this.getId().trim())) {
//			basicDBObject.put(ID, new ObjectId(this.getId().trim()));
//		}
//
//		if (null != this.getCode()) {
//			basicDBObject.put(CODE, this.getCode());
//		}
//
//		if (null != this.getName()) {
//			basicDBObject.put(NAME, this.getName());
//		}
//		
//		return basicDBObject;
//	}

	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
