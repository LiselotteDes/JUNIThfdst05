package be.vdab.valueobjects;

public class Jaar {
	private final int jaar;
	public Jaar(int jaar) {
		this.jaar = jaar;
	}
	public boolean isScrikkeljaar() {
		return jaar % 4 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
	}
	@Override
	public boolean equals(Object object) {
		if (! (object instanceof Jaar)) {
			return false;
		}
		Jaar anderJaar = (Jaar) object;
		return jaar == anderJaar.jaar;
	}
	@Override
	public int hashCode() {
		return jaar;
	}
}
