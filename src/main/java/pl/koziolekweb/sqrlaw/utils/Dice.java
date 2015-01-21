package pl.koziolekweb.sqrlaw.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public interface Dice {

	public static final Dice K4 = () -> 4;
	public static final Dice K6 = () -> 6;
	public static final Dice K8 = () -> 8;
	public static final Dice K10 = () -> 10;
	public static final Dice K12 = () -> 12;
	public static final Dice K20 = () -> 20;

	static final Random RANDOM = new Random();

	int maxDots();

	default Integer throwDice() {
		return RANDOM.nextInt(maxDots());
	}

	default Collection<Integer> throwDice(long nb) {
		return RANDOM.ints(nb, 1, maxDots() + 1).boxed().collect(Collectors.toCollection(ArrayList::new));
	}

}
