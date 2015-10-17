package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Person implements Serializable {

	private static final long serialVersionUID = 4523360233079917878L;

	private static final String ID = "_id";
	private static String DOCUMENT_TYPE = "document_type";
	private static String ID_NUMBER = "id_number";
	private static String NAME = "name";
	private static String LASTNAME = "lastname";
	private static String BIRTHDATE = "birthdate";
	private static String EMAIL = "email";
	private static String LICENSE_NUMBER = "license_number";
	private static String VEHICLES = "vehicle";

	private String id;
	private String documentType;
	private String idNumber;
	private String name;
	private String lastName;
	private Date birthDate;
	private String email;
	private String licenseNumber;
	private List<Vehicle> vehicles;

	public Person() {
		super();
	}

	public Person(String documentType, String idNumber, String name,
			String lastName, Date birthDate) {
		super();
		this.documentType = documentType;
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Person(String documentType, String idNumber, String name,
			String lastName, Date birthDate, String email,
			String licenseNumber, List<Vehicle> vehicles) {
		super();
		this.documentType = documentType;
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.vehicles = vehicles;
	}

	public static Person entityFromDBObject(DBObject dbObject) {
		Person person = null;
		if (dbObject != null) {
			person = new Person();

			if (dbObject.containsField(ID)) {
				person.setId(dbObject.get(ID).toString().trim());
			}

			if (dbObject.containsField(DOCUMENT_TYPE)) {
				person.setDocumentType((String) dbObject.get(DOCUMENT_TYPE));
			}

			if (dbObject.containsField(ID_NUMBER)) {
				person.setIdNumber((String) dbObject.get(ID_NUMBER));
			}

			if (dbObject.containsField(NAME)) {
				person.setName((String) dbObject.get(NAME));
			}

			if (dbObject.containsField(LASTNAME)) {
				person.setLastName((String) dbObject.get(LASTNAME));
			}

			if (dbObject.containsField(BIRTHDATE)) {
				person.setBirthDate((Date) dbObject.get(BIRTHDATE));
			}

			if (dbObject.containsField(EMAIL)) {
				person.setEmail((String) dbObject.get(EMAIL));
			}

			if (dbObject.containsField(LICENSE_NUMBER)) {
				person.setLicenseNumber((String) dbObject.get(LICENSE_NUMBER));
			}

			if (dbObject.containsField(VEHICLES)) {
				BasicDBList basicDBbList = (BasicDBList) dbObject.get(VEHICLES);
				person.setVehicles(new ArrayList<Vehicle>());
				for (Object object : basicDBbList) {
					person.getVehicles().add(Vehicle.entityFromDBObject((BasicDBObject) object));
				}
			}

		}

		return person;
	}

	public BasicDBObject entityToDBObject() {
		BasicDBObject basicDBObject = new BasicDBObject();

		if (null != this.getId() && !("").equals(this.getId().trim())) {
			basicDBObject.put(ID, new ObjectId(this.getId().trim()));
		}

		if (null != this.getDocumentType()) {
			basicDBObject.put(DOCUMENT_TYPE, this.getDocumentType());
		}

		if (null != this.getIdNumber()) {
			basicDBObject.put(ID_NUMBER, this.getIdNumber());
		}

		if (null != this.getName()) {
			basicDBObject.put(NAME, this.getName());
		}

		if (null != this.getLastName()) {
			basicDBObject.put(LASTNAME, this.getLastName());
		}

		if (null != this.getBirthDate()) {
			basicDBObject.put(BIRTHDATE, this.getBirthDate());
		}

		if (null != this.getEmail()) {
			basicDBObject.put(EMAIL, this.getEmail());
		}

		if (null != this.getLicenseNumber()) {
			basicDBObject.put(LICENSE_NUMBER, this.getLicenseNumber());
		}

		if (null != this.getVehicles() && !this.getVehicles().isEmpty()) {
			BasicDBList basicDBList = new BasicDBList();

			for (Vehicle vehicle : this.getVehicles()) {
				basicDBList.add(vehicle.entityToDBObject());
			}

			basicDBObject.put(VEHICLES, basicDBList);
		}

		return basicDBObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
