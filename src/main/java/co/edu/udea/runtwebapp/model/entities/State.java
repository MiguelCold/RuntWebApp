package co.edu.udea.runtwebapp.model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa la entidad State del modelo, esta
 * entidad define los estados por los cuales pasa un 
 * veh&iacute;culo con sus respectivas fechas.
 * 
 * @author David Gomez
 * @author Farley R&uacute;a S&uacute;arez
 * @author Miguel &Aacute;ngel Ossa Ruiz
 */
public class State implements Serializable{

	private static final long serialVersionUID = -4404003904493640657L;

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
