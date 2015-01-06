package pl.koziolekweb.sqrlaw;


public class Hit {

	public final int strength;

	public Hit(int strength) {
		this.strength = strength;
	}

	public static Hit missed() {
		return new Missed();
	}


	public int toWound(int t) {
		int d = strength - t;
		if (d == 0) return 4;
		if (d == 1) return 3;
		if (d == -1) return 5;
		if (d >= 2) return 2;
		if (d == -2 || d == -3) return 6;
		return 7;
	}

	private static class Missed extends Hit {

		public Missed() {
			super(0);
		}

		@Override
		public int toWound(int t) {
			return 7;
		}
	}
}
