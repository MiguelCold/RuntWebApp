package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;

public class ServiceType implements Serializable {

	private static final long serialVersionUID = -5742524916570275343L;
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
