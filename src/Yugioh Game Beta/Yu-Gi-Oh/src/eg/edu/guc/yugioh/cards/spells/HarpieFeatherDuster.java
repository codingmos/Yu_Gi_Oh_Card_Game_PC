package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {
	public HarpieFeatherDuster(String name, String description) {
		super(name, description);
	}
	public SpellCard clone(){
		return new HarpieFeatherDuster(getName(),getDescription());
		}
	
	public void action(MonsterCard monster) {
		ArrayList<SpellCard> ops = getBoard().getOpponentPlayer().getField()
				.getSpellArea();
		getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(ops);
	}
}
