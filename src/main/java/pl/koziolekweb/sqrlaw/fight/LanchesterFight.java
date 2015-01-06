package pl.koziolekweb.sqrlaw.fight;

import pl.koziolekweb.sqrlaw.Team;
import pl.koziolekweb.sqrlaw.utils.Dice;

public class LanchesterFight {

	private Team alpha;

	private Team beta;

	public LanchesterFight(Team alpha, Team beta) {
		this.alpha = alpha;
		this.beta = beta;
	}

	public WINNER start() {
		if (alpha.size() == 0) {
			return WINNER.BETA;
		}
		if (beta.size() == 0) {
			return WINNER.ALPHA;
		}
		beta = round(alpha, beta);
		if (beta.size() == 0) {
			return WINNER.ALPHA;
		}
		alpha = round(beta, alpha);
		return start();
	}

	private Team round(Team att, Team def) {
		long aHits = att.shot()
				.stream()
				.filter(h -> h.toWound(def.randomMember().toHit()) >= Dice.K6.throwDice())
				.count();
		long aKilled = Dice.K6.throwDice(aHits)
				.stream()
				.filter(t -> def.randomMember().armourSave() < t)
				.count();
		return def.kill((int) aKilled);
	}
}
