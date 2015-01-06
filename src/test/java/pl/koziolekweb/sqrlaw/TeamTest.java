package pl.koziolekweb.sqrlaw;

import org.testng.annotations.Test;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

public class TeamTest {

	@Test
	public void shouldOfMakeATeam() {
		// when
		Team team = Team.of(10, SpaceMarine::withBolter);
		// then
		assertThat(team.size()).isEqualTo(10);
	}

	@Test
	public void shouldShot() {
		// given
		Team team = Team.of(10, SpaceMarine::withBolter);
		// when
		Collection<Hit> hits = team.shot();
		// then
		assertThat(hits).hasSize(10);
	}

	@Test
	public void shouldKillCreateSmallerTeam() {
		// given
		Team team = Team.of(10, SpaceMarine::withBolter);
		// when
		team = team.kill();
		// then
		assertThat(team.size()).isEqualTo(9);
	}

	@Test
	public void shouldOverKillCreateEmptyTeam_EQ() {
		// given
		Team team = Team.of(10, SpaceMarine::withBolter);
		// when
		team = team.kill(10);
		// then
		assertThat(team.size()).isEqualTo(0);
	}

	@Test
	public void shouldOverKillCreateEmptyTeam_GT() {
		// given
		Team team = Team.of(10, SpaceMarine::withBolter);
		// when
		team = team.kill(11);
		// then
		assertThat(team.size()).isEqualTo(0);
	}
}