package co.edu.udea.runtwebapp.business.impl;

import co.edu.udea.runtwebapp.business.IVehicleBusiness;
import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.impl.VehicleDAOImpl;

public class VehicleBusinessImpl implements IVehicleBusiness {

	private static IVehicleBusiness instance;
	
	private VehicleBusinessImpl(){
		super();
	}
	
	public static synchronized IVehicleBusiness getInstance(){
		if(instance == null){
			instance = new VehicleBusinessImpl();
		}
		return instance;
	}
	
	@Override
	public Vehicle find(String carriagePlate)
			throws RuntWebAppBusinessException {
		
		try{
		if (null == carriagePlate || carriagePlate.trim().isEmpty() || "".equals(carriagePlate)) {
			throw new RuntWebAppBusinessException(
					String.format(
							"Clase %s: método %s. El parámetro carriagePlate, "
									+ "de tipo %s, no puede ser nulo ni vacío."
									+ "\n%s\n%s",
									VehicleBusinessImpl.class.getSimpleName(),
							"find()",
							String.class.getSimpleName(), carriagePlate.toString()));
		}else{
			return VehicleDAOImpl.getInstance().find(carriagePlate);
		}
		}catch(Exception e){
			throw new RuntWebAppBusinessException(String.format(
					"Clase %s: método %s. Se ha producido un error al tratar de buscar "
							+ "un vehículo por su placa.\n%s",
							VehicleBusinessImpl.class.getSimpleName(),
					"find()", e));
		}
	}

}
