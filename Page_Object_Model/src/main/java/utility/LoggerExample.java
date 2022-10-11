package utility;

import base.Base;

public class LoggerExample extends Base{

	public static void main(String[] args) {
		logger.info("This is an information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
	}
}