package api.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class config {
	public Logger logger;

	@BeforeClass
	public void setup() {

		logger = LogManager.getLogger(this.getClass());
		logger.debug("Debugging........");

	}


}
