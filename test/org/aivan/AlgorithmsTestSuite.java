package org.aivan;

import org.aivan.generators.DataGeneratorTest;
import org.aivan.sort.quicksort.QuickSortPivotFirstTest;
import org.aivan.sort.quicksort.QuickSortPivotRandomTest;
import org.aivan.sort.quicksort.QuickSortPivotSmartTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DataGeneratorTest.class, QuickSortPivotFirstTest.class, QuickSortPivotRandomTest.class,
    QuickSortPivotSmartTest.class })
public class AlgorithmsTestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
