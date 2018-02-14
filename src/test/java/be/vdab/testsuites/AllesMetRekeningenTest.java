package be.vdab.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import be.vdab.entities.RekeningTest;
import be.vdab.valueobjects.RekeningnummerTest;

// Je tikt voor de class die een test suite voorstelt @RunWith(Suite.class).
@RunWith(Suite.class)
/*
 * Je tikt voor de class die een test suite voorstelt ook @SuiteClasses.
 * Je geeft een array mee met de unit tests (of test suites) die je verzamelt in de huidige test suite.
 */
@SuiteClasses({RekeningnummerTest.class, RekeningTest.class})
public class AllesMetRekeningenTest {

}
