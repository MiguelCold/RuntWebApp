package co.edu.udea.runtwebapp.business.exception;

import org.apache.log4j.Logger;


public class RuntWebAppBusinessException extends Exception{

	private static final Logger LOGGER = Logger
			.getLogger(RuntWebAppBusinessException.class);

	private static final long serialVersionUID = -4468696866004400516L;

	public RuntWebAppBusinessException() {
		super();
		LOGGER.error("RuntWebAppBusinessException: An error has happened during process.");
	}

	public RuntWebAppBusinessException(String message) {
		super(message);
		LOGGER.error("RuntWebAppBusinessException: An error has happened during process."
				+ message);
	}

	public RuntWebAppBusinessException(Throwable cause) {
		super(cause);
		LOGGER.error(
				"RuntWebAppBusinessException: An error has happened during process.",
				cause);
	}

	public RuntWebAppBusinessException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.error(
				"RuntWebAppBusinessException: An error has happened during process.",
				cause);
	}

	public RuntWebAppBusinessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		LOGGER.error(
				"RuntWebAppBusinessException: An error has happened during process.",
				cause);
	}
	
}
