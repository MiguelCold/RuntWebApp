package co.edu.udea.runtwebapp.ws.exception;

import org.apache.log4j.Logger;

public class RuntWebAppWSException extends Exception {

	private static final Logger LOGGER = Logger
			.getLogger(RuntWebAppWSException.class);

	private static final long serialVersionUID = -4468696866004400516L;

	public RuntWebAppWSException() {
		super();
		LOGGER.error("RuntWebAppWSException: An error has happened during process.");
	}

	public RuntWebAppWSException(String message) {
		super(message);
		LOGGER.error("RuntWebAppWSException: An error has happened during process."
				+ message);
	}

	public RuntWebAppWSException(Throwable cause) {
		super(cause);
		LOGGER.error(
				"RuntWebAppWSException: An error has happened during process.",
				cause);
	}

	public RuntWebAppWSException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.error(
				"RuntWebAppWSException: An error has happened during process.",
				cause);
	}

	public RuntWebAppWSException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		LOGGER.error(
				"RuntWebAppWSException: An error has happened during process.",
				cause);
	}
}
