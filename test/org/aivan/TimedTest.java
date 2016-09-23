package org.aivan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class TimedTest {

	public static final Logger log = LogManager.getLogger(TimedTest.class);

	protected static long acumulatedDiff = 0;
	protected static long acumulatedSystem = 0;

	@Before
	public void gc() {
		log.debug("gc executed");
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
	}

	@Test
	public void z99_reportDiff() throws Exception {
		System.out.println("===================================");
		System.out.println("Accumulated diff = " + acumulatedDiff + " ("
		    + ((int) (100.0 * (acumulatedDiff * 1.0 / acumulatedSystem))) + "%)");
		System.out.println("Accumulated sys  = " + acumulatedSystem + " ("
		    + ((int) (100.0 * (acumulatedDiff * 1.0 / acumulatedSystem))) + "%)");
		System.out.println("===================================");
	}

	protected static final int SMALL_ARRAY_SIZE = 50000;
	protected static final int MEDIUM_ARRAY_SIZE = 500000;
	protected static final int LARGE_ARRAY_SIZE = 5000000;
	private static final int HUGE_ARRAY_SIZE = 50000000;

}
