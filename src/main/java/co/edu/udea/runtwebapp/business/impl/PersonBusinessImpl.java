package co.edu.udea.runtwebapp.business.impl;

import co.edu.udea.runtwebapp.business.IPersonBusiness;
import co.edu.udea.runtwebapp.business.exception.RuntWebAppBusinessException;
import co.edu.udea.runtwebapp.model.entities.Person;
import co.edu.udea.runtwebapp.persistence.dao.impl.PersonDAOImpl;

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
								"Clase %s: método %s. Los parámetros email y password, "
										+ "ambos tipo %s, no pueden ser ni nulos ni vacíos."
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
					"Clase %s: método %s. Se ha producido un error al tratar de buscar "
							+ "un usuario por email y password.\n%s",
							PersonBusinessImpl.class.getSimpleName(),
					"findByEmailAndPassword()", e));
		}
	}

}
