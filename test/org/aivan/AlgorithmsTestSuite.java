package org.aivan;

import org.aivan.generators.DataGeneratorTest;
import org.aivan.heap.Heap1Test;
import org.aivan.heap.Heap2Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DataGeneratorTest.class, Heap1Test.class, Heap2Test.class })
public class AlgorithmsTestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
