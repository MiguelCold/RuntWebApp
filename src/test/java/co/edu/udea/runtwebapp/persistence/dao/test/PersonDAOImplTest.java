package co.edu.udea.runtwebapp.persistence.dao.test;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Test;

import co.edu.udea.runtwebapp.exception.RuntWebAppTechnicalException;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.persistence.dao.IPersonDAO;
import co.edu.udea.runtwebapp.persistence.dao.exception.RuntWebAppDAOException;
import co.edu.udea.runtwebapp.persistence.dao.impl.PersonDAOImpl;
import co.edu.udea.runtwebapp.persistence.exception.RuntWebAppPersistenceBusinessException;

public class PersonDAOImplTest {
	
	public PersonDAOImplTest(){
		
	}

	@Test
	public void testFind() throws RuntWebAppDAOException,
			RuntWebAppPersistenceBusinessException,
			RuntWebAppTechnicalException, UnknownHostException {
		
		String documentType = "CEDULA";
		String idNumber = "1035859551";

		IPersonDAO personDAO = PersonDAOImpl.getInstance();
		Person person = personDAO.find(documentType, idNumber);
		
		assertTrue(person != null &&
				!("").equals(person.getId()) &&
				!("").equals(person.getDocumentType()) &&
				!("").equals(person.getIdNumber()) &&
				!("").equals(person.getName()) &&
				!("").equals(person.getLastName()) &&
				!("").equals(person.getBirthDate()) &&
				!("").equals(person.getEmail()) &&
				!("").equals(person.getLicenseNumber()) &&
				!("").equals(person.getVehicles()));
	}
}
