package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaarTest {

	@Test
	public void eenJaarDeelbaarDoor40IsEenSchrikkeljaar() {
		assertTrue(new Jaar(2000).isScrikkeljaar());
	}
	@Test
	public void eenJaarDeelbaarDoor100IsGeenSchrikkelaar() {
		assertFalse(new Jaar(1900).isScrikkeljaar());
	}
	@Test
	public void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
		assertTrue(new Jaar(2012).isScrikkeljaar());
	}
	@Test
	public void eenJaarNietDeelbaarDoor4IsGeenSchrikkeljaar() {
		assertFalse(new Jaar(2015).isScrikkeljaar());
	}
	@Test
	public void equalsOpTweeDezelfdeJarenMoetTrueZijn() {
//		assertTrue(new Jaar(2015).equals(new Jaar(2015)));
		/*
		 * assertEquals te verkiezen: geeft een handige standaard foutmelding van de vorm
		 * "expected X but got Y".
		 * assertTrue kan dit  niet.
		 */
		assertEquals(new Jaar(2015), new Jaar(2015));
	}
	@Test
	public void equalsOpTweeVerschillendeJarenMoetFalseZijn() {
		assertNotEquals(new Jaar(2015), new Jaar(2016));
	}
	@Test
	public void hashCodeOpTweeDezelfdeJarenMoetGelijkZijn() {
		assertEquals(new Jaar(2015).hashCode(), new Jaar(2015).hashCode());
	}
}
