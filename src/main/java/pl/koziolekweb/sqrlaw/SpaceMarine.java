package pl.koziolekweb.sqrlaw;

public abstract class SpaceMarine implements Unit {

	public static SpaceMarine withBolter() {
		return new SpaceMarine() {
			@Override
			public int weponStrenght() {
				return 4;
			}
		};
	}

	private SpaceMarine() {
	}

	@Override
	public int toHit() {
		return 3;
	}

	@Override
	public int armourSave() {
		return 3;
	}

	public int toughness(){
		return 4;
	}
}
