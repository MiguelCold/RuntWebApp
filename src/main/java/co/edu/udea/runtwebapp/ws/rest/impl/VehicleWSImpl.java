package co.edu.udea.runtwebapp.ws.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.business.impl.PersonBusinessImpl;
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
			+ "}")
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	@Override()
	public Response find(
			@PathParam(value = RESTFulWebServicesContract.VehicleWebServicesContract.CARRIAGE_PLATE) String carriagePlate)
			throws RuntWebAppWSException {

		if (carriagePlate == null || "".equals(carriagePlate)
				|| carriagePlate.trim().isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
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
