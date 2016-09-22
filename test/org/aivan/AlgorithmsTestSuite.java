package org.aivan;

import org.aivan.generators.DataGeneratorTest;
import org.aivan.heap.Heap1Test;
import org.aivan.heap.Heap2Test;
import org.aivan.heap.Heap3Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Trick: Heap1Test executed twice, first time to ramp-up JVM (results are usually not representative)

@RunWith(Suite.class)
@Suite.SuiteClasses({ DataGeneratorTest.class, Heap1Test.class, Heap1Test.class, Heap2Test.class, Heap3Test.class })
public class AlgorithmsTestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
