package be.vdab.valueobjects;

import java.util.regex.Pattern;

public class Rekeningnummer {
	/*
	 * Deze (parameter-)String stelt een regular expression (tekstpatroon) voor.
	 * In een regular expression hebben bepaalde tekens een speciale betekenis.
	 */
	private static final Pattern REG_EXP = Pattern.compile("^\\d{3}-\\d{7}-\\d{2}$");
	private String nummer;
	public Rekeningnummer(String nummer) {
		/*
		 * De method matches geeft enkel true terug als 
		 * de String die je meegeeft aan de method matcher past bij de regular expression in het Pattern object.
		 */
		if ( ! REG_EXP.matcher(nummer).matches()) {
			throw new IllegalArgumentException("Verkeerd formaat");
		}
		long eerste10Cijfers = Long.parseLong(nummer.substring(0, 3) + nummer.substring(4, 11));
		long laatste2Cijfers = Long.parseLong(nummer.substring(12,14));
		long rest = eerste10Cijfers % 97L;		// vergeet niet 97 aan te duiden als een long literal
		if (rest == 0) {
			if (laatste2Cijfers != 97) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		} else {
			if (rest != laatste2Cijfers) {
				throw new IllegalArgumentException("Verkeerd controlegetal");
			}
		}
		this.nummer = nummer;
	}
	@Override
	public String toString() {
		return nummer;
	}
}
