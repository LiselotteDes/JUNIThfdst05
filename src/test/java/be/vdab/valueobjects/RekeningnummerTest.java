package be.vdab.valueobjects;
import static org.junit.Assert.*;
import org.junit.Test;

public class RekeningnummerTest {
	@Test
	public void nummerMet12CijfersMetCorrectControleGetalIsOK() {
		new Rekeningnummer("063-1547564-61");	// dit mag geen exception veroorzaken
	}
	@Test
	public void alsRest0IsMoetControleGetal97Zijn() {
		new Rekeningnummer("063-1547503-97");
	}
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet12CijfersMetVerkeerdeControleIsVerkeerd() {
		new Rekeningnummer("063-1547564-62");
	}
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet12CijfersZonderStreepjesIsVerkeerd() {
		new Rekeningnummer("063154756461");
	}
	@Test(expected = IllegalArgumentException.class)
	public void nummerMet13CijfersIsVerkeerd() {
		new Rekeningnummer("063-1547564-623");
	}
	@Test(expected = IllegalArgumentException.class) 
	public void nummerMet11CijfersIsVerkeerd() {
		new Rekeningnummer("063-1547564-6");
	}
	
	// EXTREME WAARDEN
	@Test(expected = IllegalArgumentException.class)
	public void leegNummerIsVerkeerd() {
		new Rekeningnummer("");
	}
	@Test(expected = NullPointerException.class)
	public void nummerMetNullIsVerkeerd() {
		new Rekeningnummer(null);
	}
	// toString method
	@Test
	public void toStringMoetNummerTeruggeven() {
		String nummer = "063-1547564-61";
		assertEquals(nummer, new Rekeningnummer(nummer).toString());
	}
}
