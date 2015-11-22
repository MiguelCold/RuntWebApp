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
import co.edu.udea.runtwebapp.ws.rest.IPersonWS;
import co.edu.udea.runtwebapp.ws.rest.contract.RESTFulWebServicesContract;
import co.edu.udea.runtwebapp.ws.rest.util.ResponseMessage;

@Path(value = RESTFulWebServicesContract.PersonWebServicesContract.ROOT_PATH)
public class PersonWSImpl implements IPersonWS{
	
	private static final String NO_PERSON = "No se encontr� el usuario con "
			+ "los datos especificados";

	@Path(value = "/{"
			+ RESTFulWebServicesContract.PersonWebServicesContract.DOCUMENT_TYPE_PARAM
			+ "}/{"
			+ RESTFulWebServicesContract.PersonWebServicesContract.ID_NUMBER_PARAM
			+ "}")
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	@Override()
	public Response find(
			@PathParam(value = RESTFulWebServicesContract.PersonWebServicesContract.DOCUMENT_TYPE_PARAM) String documentType,
			@PathParam(value = RESTFulWebServicesContract.PersonWebServicesContract.ID_NUMBER_PARAM) String idNumber)
			throws RuntWebAppWSException {
		if (documentType == null || documentType.trim().isEmpty() || idNumber == null
				|| idNumber.trim().isEmpty()) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		Person person = null;
		try {
			person = PersonBusinessImpl.getInstance().find(documentType,idNumber);
		} catch (RuntWebAppBusinessException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}

		return (person == null) ? Response.ok(new ResponseMessage(NO_PERSON))
				.build() : Response.ok(person).build();
	}
}
