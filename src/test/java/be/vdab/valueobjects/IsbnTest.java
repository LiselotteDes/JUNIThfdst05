package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsbnTest {
	@Test(expected = IllegalArgumentException.class)
	public void hetNummer0IsVerkeerd() {
		new Isbn(0);
	}
	/*
	 * Waarom is volgende test-method verkeerd?
	 * Je geeft geen object mee aan de constructor, maar een primitieve waarde,
	 * daarom kan er geen sprake zijn van een null referentie door te geven.
	 */
//	@Test(expected = NullPointerException.class)
//	public void nummerMetNullIsVerkeerd() {
//		new Isbn(null);		// ! dit levert een syntaxfout in eclipse
//	}
	
	/*
	 * Gegeven: correct isbn nummer "9789027439642L"
	 * Correcte lengte, prefix-getal, controle-getal
	 */
	// Moest het gegeven getal negatief zijn:
	@Test(expected = IllegalArgumentException.class)
	public void eenNegatiefNummerIsVerkeerd() {
		new Isbn(-9789027439642L);
	}
	// Moest het gegeven getal een cijfer te weinig hebben:
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet12CijfersIsVerkeerd() {
		new Isbn(978902743964L);
	}
	// Moest het gegeven getal een cijfer te veel hebben:
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet14CijfersIsVerkeerd() {
		new Isbn(97890274396421L);
	}
	@Test(expected = IllegalArgumentException.class)
	public void deEerste3CijfersMoeten978of979Zijn() {
		new Isbn(9779227439643L);
	}
	// Moest in het gegeven getal een cijfer veranderen zodat het controle-verschil niet meer klopt met het controle-cijfer
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet13CijfersMetVerkeerdControleGetal2IsVerkeerd() {
		new Isbn(8789027439642L);
	}
	// Moest het gegeven getal getest worden
	@Test
	public void nummerMet13CijfersMetCorrectControleGetal2IsOk() {
		new Isbn(9789027439642L);
	}
	// Moest in het gegeven getal het controle-cijfer veranderd worden zodat het niet meer klopt
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet13CijfersMetVerkeerdControleGetal3IsVerkeerd() {
		new Isbn(9789027439643L);
	}
	@Test
	public void alsVerschil10IsMoetControleGetal0zijn() {
		new Isbn(9789227439640L);
	}
	@Test
	public void toStringMoetNummerTeruggeven() {
		long nummer = 9789027439642L;
		assertEquals(nummer, Long.parseLong(new Isbn(nummer).toString()));
	}
}
