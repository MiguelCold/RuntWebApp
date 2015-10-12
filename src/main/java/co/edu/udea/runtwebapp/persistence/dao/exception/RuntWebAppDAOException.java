package co.edu.udea.runtwebapp.persistence.dao.exception;

import org.apache.log4j.Logger;

public class RuntWebAppDAOException extends Exception {

	/**
	 * Atributo constante para realizar la gesti&oacute;n de los errores a
	 * trav&eacute;s de un <b>LOG</b> gen&eacute;rico.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(RuntWebAppDAOException.class);

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n y
	 * deserializaci&oacute;n de la instancia {@code RuntWebAppDAOException}, e
	 * igualmente, de todos los atributos esta instancia agrupe.
	 */
	private static final long serialVersionUID = -4468696866004400516L;

	/**
	 * Constructor por defecto y sin par&aacute;metros para generar instancias
	 * de esta clase.
	 * <p>
	 * Este constructor realizar&aacute; una llamada expl&iacute;cita a su
	 * constructor padre. Por otra parte, el constructor est&aacute; en la
	 * capacidad de escribir en el archivo de LOG definido para la
	 * aplicaci&oacute;n.
	 */
	public RuntWebAppDAOException() {
		super();
		LOGGER.error("RuntWebAppDAOException: An error has happened during process.");
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje personalizado para la excepci&oacute;n a ser creada. Por otra
	 * parte, el constructor est&aacute; en la capacidad de escribir en el
	 * archivo de LOG definido para la aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 */
	public RuntWebAppDAOException(String message) {
		super(message);
		LOGGER.error("RuntWebAppDAOException: An error has happened during process."
				+ message);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * una instancia {@code Throwable} personalizada para la excepci&oacute;n a
	 * ser creada. Por otra parte, el constructor est&aacute; en la capacidad de
	 * escribir en el archivo de LOG definido para la aplicaci&oacute;n.
	 * 
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 */
	public RuntWebAppDAOException(Throwable cause) {
		super(cause);
		LOGGER.error(
				"RuntWebAppDAOException: An error has happened during process.",
				cause);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje y una instancia {@code Throwable} personalizada para la
	 * excepci&oacute;n a ser creada. Por otra parte, el constructor est&aacute;
	 * en la capacidad de escribir en el archivo de LOG definido para la
	 * aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 */
	public RuntWebAppDAOException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.error(
				"RuntWebAppDAOException: An error has happened during process.",
				cause);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje y una instancia {@code Throwable} personalizada para la
	 * excepci&oacute;n a ser creada, junto con atributos para especificar la
	 * forma en la que los mensajes deben ser mostrados. Por otra parte, el
	 * constructor est&aacute; en la capacidad de escribir en el archivo de LOG
	 * definido para la aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 * @param enableSuppression
	 *            Indica si la supresi&oacute;n es activada o no.
	 * @param writableStackTrace
	 *            Indica si el mensaje debe ser mostrado en la pila de llamadas.
	 *            <code>true</code> indica que el mensaje ha de ser escrito en
	 *            la pila de llamadas.
	 */
	public RuntWebAppDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		LOGGER.error(
				"RuntWebAppDAOException: An error has happened during process.",
				cause);
	}
}
