package pl.koziolekweb.sqrlaw.utils;

import org.fest.assertions.Assertions;
import org.fest.assertions.Delta;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Delta.delta;

public class DiceTest {

	@Test
	public void shouldThrowDice() {
		double asDouble = Dice.K6.throwDice(50)
				.stream()
				.collect(Collectors.groupingBy(i -> i))
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.flatMap(i -> i.stream())
				.mapToInt(i -> i)
				.average().getAsDouble();

		assertThat(asDouble).isEqualTo(3.5, delta(0.05 * 3.5));
	}
}