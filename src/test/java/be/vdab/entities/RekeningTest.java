package be.vdab.entities;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RekeningTest {
	private Rekening rekening;
	@Before
	public void before() {
		rekening = new Rekening();
	}
	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		assertEquals(0, BigDecimal.ZERO.compareTo(rekening.getSaldo()));
	}
	@Test
	public void hetSaldoNaEenStortingIsHetBedragVanDieStorting() {
		BigDecimal bedrag = BigDecimal.valueOf(2.5);
		rekening.storten(bedrag);
		assertEquals(0, bedrag.compareTo(rekening.getSaldo()));
	}
	@Test
	public void hetSaldoNaTweeStortingenIsDeSomVanDeBedragenVanDieStortingen() {
		rekening.storten(BigDecimal.valueOf(2.5));
		rekening.storten(BigDecimal.valueOf(1.2));
		assertEquals(0, BigDecimal.valueOf(3.7).compareTo(rekening.getSaldo()));
	}
	/*
	 * Als je een verkeerde waarde meegeeft aan de constructor of een method, 
	 * is deze correct als hij een exception werpt.
	 * Je schrijft extra tests voor deze vereisten.
	 */
	
	/*
	 * Je test in deze @Test method een situatie die tot een IllegalArgumentException moet leiden:
	 * Je probeert nul euro te storten.
	 * Je vermeldt deze verwachte exceptie als de parameter expected van @Test.
	 * Enkel als deze exception optreedt is deze test volgens JUnit geslaagd.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNulZijn() {
		rekening.storten(BigDecimal.ZERO);
	}
	// De parameter van de method storten moet een positief getal, zoniet > IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNegatiefZijn() {
		rekening.storten(BigDecimal.valueOf(-1));
	}
	// Als je null meegeeft als parameter aan storten moet de method een NullPointerException werpen.
	@Test(expected = NullPointerException.class)
	public void hetBedragVanEenStortingMagNietNullZijn() {
		rekening.storten(null);
	}
}
