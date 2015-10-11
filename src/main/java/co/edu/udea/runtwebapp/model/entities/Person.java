package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {

	private static final long serialVersionUID = 4523360233079917878L;
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
