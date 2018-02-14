package be.vdab.valueobjects;

public class Jaar {
	private final int jaar;
	public Jaar(int jaar) {
		this.jaar = jaar;
	}
	public boolean isScrikkeljaar() {
		return jaar % 4 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
	}
}
