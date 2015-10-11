package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Vehicle implements Serializable {

	private static final long serialVersionUID = 7486774537053409983L;
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
	private String clasic;
	private String line;
	private String color;
	private String motorNumber;
	private String bodyType;
	private Date registerDate;

	public Vehicle() {
		super();
	}

	public Vehicle(String carriagePlate, Brand brand, String model,
			String serialNumber, String classType, State state,
			ServiceType serviceType, String chassisNumber,
			String cylinderCapacity, String fuelType, String trafficAuthority,
			String clasic, String line, String color, String motorNumber,
			String bodyType, Date registerDate) {
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
		this.clasic = clasic;
		this.line = line;
		this.color = color;
		this.motorNumber = motorNumber;
		this.bodyType = bodyType;
		this.registerDate = registerDate;
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

	public String getClasic() {
		return clasic;
	}

	public void setClasic(String clasic) {
		this.clasic = clasic;
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

}
