package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster {
	public HeavyStorm(String name, String description) {
		super(name, description);
	}
	public SpellCard clone(){
		return new HeavyStorm(getName(),getDescription());
		}
	public void action(MonsterCard monster) {
		ArrayList<SpellCard> aps = getBoard().getActivePlayer().getField()
				.getSpellArea();
		getBoard().getActivePlayer().getField().removeSpellToGraveyard(aps);
		// ArrayList<SpellCard> ops =
		// getBoard().getOpponentPlayer().getField().getSpellArea();
		// getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(ops);
		super.action(monster);

	}
}
