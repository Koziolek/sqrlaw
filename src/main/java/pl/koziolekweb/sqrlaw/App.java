package pl.koziolekweb.sqrlaw;

import com.google.common.base.Stopwatch;
import pl.koziolekweb.sqrlaw.fight.LanchesterFight;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.text.MessageFormat.format;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class App {

	public static void main(String[] args) {
		Stopwatch started = Stopwatch.createStarted();
		Stream.generate(() -> {
			Team alpha = Team.of(10, SpaceMarine::withBolter);
			Team beta = Team.of(8, SpaceMarine::withBolter).withUnitOf(2, SpaceMarine::withHeavyBolter);
			return new LanchesterFight(alpha, beta);
		}).parallel().limit(1000000)
				.map(f -> f.start())
				.collect(Collectors.groupingByConcurrent(w -> w))
				.entrySet()
				.stream()
				.sorted((l, r) -> l.getKey().name().compareTo(r.getKey().name()))
				.forEach(e -> System.out.println(format("PKL: {0} wins {1} times", e.getKey(), e.getValue().size())));
		System.out.printf("takes " + started.elapsed(TimeUnit.MILLISECONDS));
//
//		Stream.generate(() -> {
//			Team alpha = Team.of(10, SpaceMarine::withBolter);
//			Team beta = Team.of(10, SpaceMarine::withBolter);
//			return new SalvoFight(alpha, beta);
//		}).limit(100000)
//				.map(f -> f.start())
//				.collect(Collectors.groupingByConcurrent(w -> w))
//				.entrySet()
//				.stream()
//				.sorted((l, r) -> l.getKey().name().compareTo(r.getKey().name()))
//				.forEach(e -> System.out.println(format("S: {0} wins {1} times", e.getKey(), e.getValue().size())));
	}
}
