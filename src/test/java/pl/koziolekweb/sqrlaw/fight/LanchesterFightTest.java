package pl.koziolekweb.sqrlaw.fight;

import static org.fest.assertions.Assertions.*;

import org.testng.annotations.Test;
import pl.koziolekweb.sqrlaw.SpaceMarine;
import pl.koziolekweb.sqrlaw.Team;

public class LanchesterFightTest {

	@Test
	public void shouldName() {
		Team alpha = Team.of(2, SpaceMarine::withBolter);
		Team beta = Team.of(2, SpaceMarine::withHeavyBolter);
		LanchesterFight lanchesterFight = new LanchesterFight(alpha, beta);
		WINNER start = lanchesterFight.start();

	}
}