package pl.koziolekweb.sqrlaw;

import pl.koziolekweb.sqrlaw.fight.LanchesterFight;
import pl.koziolekweb.sqrlaw.fight.SalvoFight;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.text.MessageFormat.format;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class App {

	public static void main(String[] args) {

		Stream.generate(() -> {
			Team alpha = Team.of(10, SpaceMarine::withBolter);
			Team beta = Team.of(10, SpaceMarine::withBolter);
			return new LanchesterFight(alpha, beta);
		}).limit(100000)
				.map(f -> f.start())
				.collect(Collectors.groupingByConcurrent(w -> w))
				.entrySet()
				.stream()
				.sorted((l, r) -> l.getKey().name().compareTo(r.getKey().name()))
				.forEach(e -> System.out.println(format("PKL: {0} wins {1} times", e.getKey(), e.getValue().size())));

		Stream.generate(() -> {
			Team alpha = Team.of(10, SpaceMarine::withBolter);
			Team beta = Team.of(10, SpaceMarine::withBolter);
			return new SalvoFight(alpha, beta);
		}).limit(100000)
				.map(f -> f.start())
				.collect(Collectors.groupingByConcurrent(w -> w))
				.entrySet()
				.stream()
				.sorted((l, r) -> l.getKey().name().compareTo(r.getKey().name()))
				.forEach(e -> System.out.println(format("S: {0} wins {1} times", e.getKey(), e.getValue().size())));
	}
}
