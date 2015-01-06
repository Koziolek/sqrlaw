package pl.koziolekweb.sqrlaw;


public class Hit {

	public final int strength;

	public Hit(int strength) {
		this.strength = strength;
	}

	public static Hit missed(){
		return new Missed();
	}


	public int toWound(int t) {
		int d = t - strength;
		if (d == 0) return 4;
		if (d > 2) return 7; // out of scope for d6
		return 4 + d;
	}

	private static class Missed extends Hit {

		public Missed() {
			super(0);
		}

		@Override
		public int toWound(int t) {
			return 13;
		}
	}
}
