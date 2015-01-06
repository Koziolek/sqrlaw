package pl.koziolekweb.sqrlaw;

import pl.koziolekweb.sqrlaw.utils.Dice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Team {

	private static final Team ZERO = new Team(Collections.emptyList());

	private List<Unit> units;

	public static Team of(int size, Supplier<Unit> unit) {
		return new Team(
				Stream
						.generate(unit)
						.limit(size)
						.collect(Collectors.toList()));
	}

	public Team withUnitOf(Unit unit) {
		return withUnitOf(1, () -> unit);
	}

	public Team withUnitOf(int size, Supplier<Unit> unit) {
		List<Unit> additionalUnits = Stream
				.generate(unit)
				.limit(size)
				.collect(Collectors.toList());
		List<Unit> newList = new ArrayList<>(units);
		newList.addAll(additionalUnits);
		return new Team(newList);
	}


	private Team(List<Unit> units) {
		this.units = units;
	}

	public Collection<Hit> shot() {
		return units.stream()
				.map(u -> Dice.K6.throwDice() >= u.toHit() ? new Hit(u.weponStrenght()) : Hit.missed())
				.collect(Collectors.toList());
	}

	public int size() {
		return units.size();
	}

	public Team kill() {
		return kill(1);
	}

	public Team kill(int kia) {
		if (kia >= size()) {
			return ZERO;
		}
		return new Team(units.subList(0, units.size() - kia));
	}

	public Unit randomMember() {
		return units.get(Dice.RANDOM.nextInt(units.size()));
	}
}