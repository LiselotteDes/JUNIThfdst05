package be.vdab.valueobjects;

import java.util.HashSet;
import java.util.Set;

public class Isbn {
	private static final long KLEINSTE_GETAL_MET_13_CIJFERS = 1000_000_000_000L;
	private static final long GROOTSTE_GETAL_MET_13_CIJFERS = 9999_999_999_999L;
	private static final Set<Short> MOGELIJKE_EERSTE_3_CIJFERS = new HashSet<>();	
	private final long nummer;

	static {
		/*
		 * Deze static initializer wordt één keer uitgevoerd in het programma,
		 * als je de eerste keer de class Isbnr aanspreekt.
		 * Je kan in deze static initializer enkel static variabelen manipuleren.
		 */
		MOGELIJKE_EERSTE_3_CIJFERS.add((short) 978);
		MOGELIJKE_EERSTE_3_CIJFERS.add((short) 979);
	}
	
	public Isbn(long nummer) {
		// Controle op de lengte van een getal.
		if (nummer < KLEINSTE_GETAL_MET_13_CIJFERS || nummer > GROOTSTE_GETAL_MET_13_CIJFERS) {
			throw new IllegalArgumentException("Bevat geen 13 cijfers");
		}
		// Controle dat het getal bestaande uit de eerste 3 cijfers, een short is uit de verzameling MOGELIJKE_EERSTE_3_CIJFERS
		short eerste3Cijfers = (short) (nummer / 10_000_000_000L);
		if (! MOGELIJKE_EERSTE_3_CIJFERS.contains(eerste3Cijfers)) {
			throw new IllegalArgumentException("Begint niet met " + MOGELIJKE_EERSTE_3_CIJFERS);
		}
		// Controle-mechanisme
		long somEvenCijfers = 0;
		long somOnevenCijfers = 0;
		long teVerwerkenCijfers = nummer / 10;
		for (int teller = 0; teller != 6; teller++) {
			somEvenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
			somOnevenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
		}
		long controleGetal = somEvenCijfers * 3 + somOnevenCijfers;
		long naastGelegenHoger10tal = controleGetal - controleGetal % 10 + 10;
		long verschil = naastGelegenHoger10tal - controleGetal;
		long laatsteCijfer = nummer % 10;
		if (verschil == 10) {
			if (laatsteCijfer != 0) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		} else {
			if (verschil != laatsteCijfer) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		}
		this.nummer = nummer;
	}
	@Override
	public String toString() {
		return String.valueOf(nummer);
	}
}
