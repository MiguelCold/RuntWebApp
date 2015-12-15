package co.edu.udea.runtwebapp.ws.rest.impl;


import java.nio.file.Files;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;

import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.business.impl.PersonBusinessImpl;
import co.edu.udea.runtwebapp.domain.alpr.AlprRecognizer;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.ws.exception.RuntWebAppWSException;
import co.edu.udea.runtwebapp.ws.rest.IVehicleWS;
import co.edu.udea.runtwebapp.ws.rest.contract.RESTFulWebServicesContract;
import co.edu.udea.runtwebapp.ws.rest.util.ResponseMessage;

@Path(value = RESTFulWebServicesContract.VehicleWebServicesContract.ROOT_PATH)
public class VehicleWSImpl implements IVehicleWS {

	private static final String NO_VEHICLE = "No se encontró el vehículo con "
			+ "los datos especificados";
	
	@Path(value = "/{"
			+ RESTFulWebServicesContract.VehicleWebServicesContract.CARRIAGE_PLATE
			+"}")
	@GET()
	@Consumes("*/*")
	@Produces(MediaType.APPLICATION_JSON)
	@Override()
	public Response find(
			@PathParam(value = 
			RESTFulWebServicesContract.VehicleWebServicesContract.CARRIAGE_PLATE) 
			String carriagePlate)
			throws RuntWebAppWSException, Exception{
		
		String licensePlate = "C:/Plate.jpg";
		java.nio.file.Path path = java.nio.file.Paths.get(licensePlate);
		byte[] imageData = Files.readAllBytes(path);
		
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate(imageData);
        List<AlprPlateResult> list= alprResults.getPlates();
        
        for (AlprPlateResult plate  : list) {
            if (plate.getBestPlate().getCharacters().equals("MIV792")) {
            	carriagePlate = plate.getBestPlate().getCharacters();
            }
        }
		
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
