package co.edu.udea.runtwebapp.ws.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.openalpr.jni.AlprPlateResult;

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
	public Response find(byte[] imageData) throws RuntWebAppWSException,
			Exception {
		try {
			ControllerRecognizer alprRecognizer = new ControllerRecognizer();
			List<AlprPlateResult> list = alprRecognizer
					.recognizePlate(imageData);
			String carriagePlate = "";
			Person person = null;
			for (AlprPlateResult alprPlateResult : list) {
				carriagePlate = alprPlateResult.getBestPlate().getCharacters();
				if (carriagePlate != null && !"".equals(carriagePlate)
						&& !carriagePlate.trim().isEmpty()) {

					person = PersonBusinessImpl.getInstance()
							.findByCarriagePlate(carriagePlate);

					if (person != null) {
						return Response.ok(person).build();
					}
				}

			}
			return Response.ok(new ResponseMessage(NO_VEHICLE)).build();
		} catch (RuntWebAppBusinessException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

}
