package co.edu.udea.runtwebapp.ws.rest;

import javax.ws.rs.core.Response;

import co.edu.udea.runtwebapp.ws.exception.RuntWebAppWSException;

public interface IVehicleWS {

//	public Response find(String carriagePlate)
//			throws RuntWebAppWSException;
	
	public Response find(byte[] imageData)
			throws RuntWebAppWSException, Exception;
}
