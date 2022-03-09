package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends SpellCard {
	public Raigeki(String name, String description){
		super(name, description);
	}
	public SpellCard clone(){
		return new Raigeki(getName(),getDescription());
		}
	
	public void action(MonsterCard monster){
		ArrayList<MonsterCard> opm = getBoard().getOpponentPlayer().getField().getMonstersArea();
		getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(opm);
		
		for(MonsterCard m : opm)
		{
			
			getBoard().getOpponentPlayer().getField().getGraveyard().add(m);
			m.setLocation(Location.GRAVEYARD);
		}
		opm.clear();
	}

	
}
