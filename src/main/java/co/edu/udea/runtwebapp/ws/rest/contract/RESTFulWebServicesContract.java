package co.edu.udea.runtwebapp.ws.rest.contract;

public class RESTFulWebServicesContract {

	private RESTFulWebServicesContract() {
		super();
	}

	public static final class PersonWebServicesContract {

		/*
		 * Parameteres
		 */
		public static final String DOCUMENT_TYPE_PARAM = "documentType";
		public static final String ID_NUMBER_PARAM = "idNumber";

		/*
		 * Paths
		 */
		public static final String ROOT_PATH = "/person";

		private PersonWebServicesContract() {
			super();
		}
	}
	
	public static final class VehicleWebServicesContract {

		/*
		 * Parameteres
		 */
		public static final String CARRIAGE_PLATE = "carriagePlate";

		/*
		 * Paths
		 */
		public static final String ROOT_PATH = "/vehicle";

		private VehicleWebServicesContract() {
			super();
		}
	}
}
