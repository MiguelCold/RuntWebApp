package co.edu.udea.runtwebapp.ws.rest;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import co.edu.udea.runtwebapp.ws.exception.RuntWebAppWSException;

public interface IVehicleWS {

	public Response find(JSONObject imageData)
			throws RuntWebAppWSException, Exception;
}
