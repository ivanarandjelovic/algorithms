package org.aivan;

import org.aivan.generators.DataGeneratorTest;
import org.aivan.heap.HeapTest1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DataGeneratorTest.class, HeapTest1.class })
public class AlgorithmsTestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
