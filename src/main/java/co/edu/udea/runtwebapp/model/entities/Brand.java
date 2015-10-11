package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;

public class Brand implements Serializable{

	private static final long serialVersionUID = -809411911029084501L;
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