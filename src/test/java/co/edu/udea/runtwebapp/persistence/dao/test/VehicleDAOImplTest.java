package co.edu.udea.runtwebapp.persistence.dao.test;

import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import org.junit.Test;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;
import co.edu.udea.runtwebapp.model.entities.Vehicle;
import co.edu.udea.runtwebapp.persistence.dao.IVehicleDAO;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.dao.impl.VehicleDAOImpl;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public class VehicleDAOImplTest {
	
	public VehicleDAOImplTest(){

	}
	
	@Test
	public void testFind() throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException,
			RuntWebAppTechnicalException, UnknownHostException {
		
		String carriagePlate = "MMM888";

		IVehicleDAO vehicleDAO = VehicleDAOImpl.getInstance();
		Vehicle vehicle = vehicleDAO.find(carriagePlate);
		
		assertTrue(vehicle != null && 
				vehicle.getCarriagePlate() != null &&
				vehicle.getBrand() != null &&
				vehicle.getModel() != null &&
				vehicle.getSerialNumber() != null &&
				vehicle.getClassType() != null &&
				vehicle.getState() != null &&
				vehicle.getServiceType() != null &&
				vehicle.getChassisNumber() != null &&
				vehicle.getCylinderCapacity() != null &&
				vehicle.getFuelType() != null &&
				vehicle.getTrafficAuthority() != null &&
				vehicle.getClassic() != null &&
				vehicle.getLine() != null &&
				vehicle.getColor() != null &&
				vehicle.getMotorNumber() != null &&
				vehicle.getBodyType() != null &&
				vehicle.getRegisterDate() != null);
	}
}
