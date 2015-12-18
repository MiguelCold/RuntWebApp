package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.DBObject;

@XmlAccessorType(value = XmlAccessType.PROPERTY)
@XmlRootElement()
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 7486774537053409983L;
	
	private static final String ID = "_id";
	private static String CARRIAGE_PLATE = "carriage_plate";
	private static String BRAND = "brand";
	private static String MODEL = "model";
	private static String SERIAL_NUMBER = "serial_number";
	private static String CLASS_TYPE = "class_type";
	private static String STATE = "state";
	private static String SERVICE_TYPE = "service_type";
	private static String CHASSIS_NUMBER = "chassis_number";
	private static String CYLINDER_CAPACITY = "cylinder_capacity";
	private static String FUEL_TYPE = "fuel_type";
	private static String TRAFFIC_AUTHORITY = "traffic_authority";
	private static String CLASSIC = "classic";
	private static String LINE = "line";
	private static String COLOR = "color";
	private static String MOTOR_NUMBER = "motor_number";
	private static String BODY_TYPE = "body_type";
	private static String REGISTER_DATE = "register_date";
	private static String MECHANICAL_TECHNO = "mechanical_techno";
	private static String SOAT = "soat";
	
	private String id;
	private String carriagePlate;
	private Brand brand;
	private String model;
	private String serialNumber;
	private String classType;
	private State state;
	private ServiceType serviceType;
	private String chassisNumber;
	private String cylinderCapacity;
	private String fuelType;
	private String trafficAuthority;
	private String classic;
	private String line;
	private String color;
	private String motorNumber;
	private String bodyType;
	private Date registerDate;
	private Date mechanicalTechno;
	private Date soat;

	public Vehicle() {
		super();
	}

	public Vehicle(String carriagePlate, Brand brand, String model,
			String serialNumber, String classType, State state,
			ServiceType serviceType, String chassisNumber,
			String cylinderCapacity, String fuelType, String trafficAuthority,
			String classic, String line, String color, String motorNumber,
			String bodyType, Date registerDate, Date mechanicalTechno, Date soat) {
		super();
		this.carriagePlate = carriagePlate;
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
		this.classType = classType;
		this.state = state;
		this.serviceType = serviceType;
		this.chassisNumber = chassisNumber;
		this.cylinderCapacity = cylinderCapacity;
		this.fuelType = fuelType;
		this.trafficAuthority = trafficAuthority;
		this.classic = classic;
		this.line = line;
		this.color = color;
		this.motorNumber = motorNumber;
		this.bodyType = bodyType;
		this.registerDate = registerDate;
		this.mechanicalTechno = mechanicalTechno;
		this.soat = soat;
	}
	
	public static Vehicle entityFromDBObject(DBObject dbObject) {
		Vehicle vehicle = null;
		if (dbObject != null) {
			vehicle = new Vehicle();

			if (dbObject.containsField(ID)) {
				vehicle.setId(dbObject.get(ID).toString().trim());
			}

			if (dbObject.containsField(CARRIAGE_PLATE)) {
				vehicle.setCarriagePlate((String) dbObject.get(CARRIAGE_PLATE));
			}

			if (dbObject.containsField(BRAND)) {
				vehicle.setBrand(Brand.entityFromDBObject((DBObject) dbObject
						.get(BRAND)));
			}

			if (dbObject.containsField(MODEL)) {
				vehicle.setModel((String) dbObject.get(MODEL));
			}

			if (dbObject.containsField(SERIAL_NUMBER)) {
				vehicle.setSerialNumber((String) dbObject.get(SERIAL_NUMBER));
			}

			if (dbObject.containsField(CLASS_TYPE)) {
				vehicle.setClassType((String) dbObject.get(CLASS_TYPE));
			}

			if (dbObject.containsField(STATE)) {
				vehicle.setState(State.entityFromDBObject((DBObject) dbObject
						.get(STATE)));
			}

			if (dbObject.containsField(SERVICE_TYPE)) {
				vehicle.setServiceType(ServiceType.entityFromDBObject((DBObject) dbObject
						.get(SERVICE_TYPE)));
			}
			
			if (dbObject.containsField(CHASSIS_NUMBER)) {
				vehicle.setChassisNumber((String) dbObject.get(CHASSIS_NUMBER));
			}
			
			if (dbObject.containsField(CYLINDER_CAPACITY)) {
				vehicle.setCylinderCapacity((String) dbObject.get(CYLINDER_CAPACITY));
			}
			
			if (dbObject.containsField(FUEL_TYPE)) {
				vehicle.setFuelType((String) dbObject.get(FUEL_TYPE));
			}
			
			if (dbObject.containsField(TRAFFIC_AUTHORITY)) {
				vehicle.setTrafficAuthority((String) dbObject.get(TRAFFIC_AUTHORITY));
			}
			
			if (dbObject.containsField(CLASSIC)) {
				vehicle.setClassic((String) dbObject.get(CLASSIC));
			}
			
			if (dbObject.containsField(LINE)) {
				vehicle.setLine((String) dbObject.get(LINE));
			}
			
			if (dbObject.containsField(COLOR)) {
				vehicle.setColor((String) dbObject.get(COLOR));
			}
			
			if (dbObject.containsField(MOTOR_NUMBER)) {
				vehicle.setMotorNumber((String) dbObject.get(MOTOR_NUMBER));
			}
			
			if (dbObject.containsField(BODY_TYPE)) {
				vehicle.setBodyType((String) dbObject.get(BODY_TYPE));
			}
			
			if (dbObject.containsField(REGISTER_DATE)) {
				vehicle.setRegisterDate((Date) dbObject.get(REGISTER_DATE));
			}
			
			if (dbObject.containsField(MECHANICAL_TECHNO)) {
				vehicle.setMechanicalTechno((Date) dbObject.get(MECHANICAL_TECHNO));
			}
			
			if (dbObject.containsField(SOAT)) {
				vehicle.setSoat((Date) dbObject.get(SOAT));
			}
		}

		return vehicle;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarriagePlate() {
		return carriagePlate;
	}

	public void setCarriagePlate(String carriagePlate) {
		this.carriagePlate = carriagePlate;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(String cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTrafficAuthority() {
		return trafficAuthority;
	}

	public void setTrafficAuthority(String trafficAuthority) {
		this.trafficAuthority = trafficAuthority;
	}

	public String getClassic() {
		return classic;
	}

	public void setClassic(String classic) {
		this.classic = classic;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotorNumber() {
		return motorNumber;
	}

	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getMechanicalTechno() {
		return mechanicalTechno;
	}

	public void setMechanicalTechno(Date mechanicalTechno) {
		this.mechanicalTechno = mechanicalTechno;
	}

	public Date getSoat() {
		return soat;
	}

	public void setSoat(Date soat) {
		this.soat = soat;
	}
}
