package co.edu.udea.runtwebapp.ws.rest.impl;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.business.impl.PersonBusinessImpl;
import co.edu.udea.runtwebapp.domain.alpr.ControllerRecognizer;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.ws.exception.RuntWebAppWSException;
import co.edu.udea.runtwebapp.ws.rest.IVehicleWS;
import co.edu.udea.runtwebapp.ws.rest.contract.RESTFulWebServicesContract;
import co.edu.udea.runtwebapp.ws.rest.util.ResponseMessage;

@Path(value = RESTFulWebServicesContract.VehicleWebServicesContract.ROOT_PATH)
public class VehicleWSImpl implements IVehicleWS {

	private static final String NO_VEHICLE = "No se encontró el vehículo con "
			+ "los datos especificados";
	
	@POST
	@Consumes("*/*")
	@Produces(MediaType.APPLICATION_JSON)
	@Override()
	public Response find(String imageData)
			throws RuntWebAppWSException, Exception{
		
		//String imageText = (String)imageData.get("imageData");
		byte [] imageData2 = imageData.getBytes();
		ControllerRecognizer alprRecognizer = new ControllerRecognizer();
		String carriagePlate = alprRecognizer.recognizePlate(imageData2);
		
		if (carriagePlate == null || "".equals(carriagePlate)
				|| carriagePlate.trim().isEmpty()) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
        
		Person person = null;
		
		try{
			person = PersonBusinessImpl.getInstance().findByCarriagePlate(carriagePlate);
		}catch(RuntWebAppBusinessException e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		
		return (person == null) ? Response.ok(new ResponseMessage(NO_VEHICLE))
				.build() : Response.ok(person).build();
	}

}
