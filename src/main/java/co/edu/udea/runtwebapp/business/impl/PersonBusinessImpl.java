package co.edu.udea.runtwebapp.business.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.runtwebapp.business.IPersonBusiness;
import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.impl.PersonDAOImpl;
import co.edu.udea.runtwebapp.persistence.dao.impl.VehicleDAOImpl;

public class PersonBusinessImpl implements IPersonBusiness{

	private static IPersonBusiness instance;

	private PersonBusinessImpl() {
		super();
	}

	public static synchronized IPersonBusiness getInstance() {
		if (instance == null) {
			instance = new PersonBusinessImpl();
		}

		return instance;
	}
	@Override
	public Person find(String documentType, String idNumber)
			throws RuntWebAppBusinessException {
		try {
			if (null == documentType || documentType.trim().isEmpty() || null == idNumber
					|| idNumber.trim().isEmpty()) {
				throw new RuntWebAppBusinessException(
						String.format(
								"Clase %s: m�todo %s. Los par�metros email y password, "
										+ "ambos tipo %s, no pueden ser ni nulos ni vac�os."
										+ "\n%s\n%s",
										PersonBusinessImpl.class.getSimpleName(),
								"findByEmailAndPassword()",
								String.class.getSimpleName(), documentType.toString(),
								idNumber.toString()));
			} else {

				return PersonDAOImpl.getInstance().find(documentType,
						idNumber);
			}
		} catch (Exception e) {
			throw new RuntWebAppBusinessException(String.format(
					"Clase %s: m�todo %s. Se ha producido un error al tratar de buscar "
							+ "un usuario por email y password.\n%s",
							PersonBusinessImpl.class.getSimpleName(),
					"findByEmailAndPassword()", e));
		}
	}

	@Override
	public Person findByCarriagePlate(String carriagePlate)
			throws RuntWebAppBusinessException {
	
		try {
			if (null == carriagePlate || carriagePlate.trim().isEmpty() 
					|| "".equals(carriagePlate)) {
				throw new RuntWebAppBusinessException(
						String.format(
								"Clase %s: método %s. El parámetro carriagePlate, "
										+ "de tipo %s, no puede ser nulo ni vacío."
										+ "\n%s\n%s",
										PersonBusinessImpl.class.getSimpleName(),
								"findByCarriagePlate()",
								String.class.getSimpleName(), carriagePlate.toString()));
			} else {

				Vehicle vehicle = null;
				vehicle = VehicleDAOImpl.getInstance().find(carriagePlate);
				Person person = null;
				person = PersonDAOImpl.getInstance().findByCarriagePlate(carriagePlate);
				List<Vehicle> vehicles = new ArrayList<Vehicle>();
				if(vehicle != null && person != null){
					vehicles.add(vehicle);
					person.setVehicles(vehicles);
				}
				return person;
			}
		} catch (Exception e) {
			throw new RuntWebAppBusinessException(String.format(
					"Clase %s: método %s. Se ha producido un error al tratar de buscar "
							+ "un usuario por la placa de un vehículo.\n%s",
							PersonBusinessImpl.class.getSimpleName(),
					"findByCarriagePlate()", e));
		}
	}

}
