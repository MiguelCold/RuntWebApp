package co.edu.udea.runtwebapp.ws.rest;

import javax.ws.rs.core.Response;

import co.edu.udea.runtwebapp.ws.exception.RuntWebAppWSException;

public interface IPersonWS {
	
	public Response find(String documentType, String idNumber)
			throws RuntWebAppWSException;
}
