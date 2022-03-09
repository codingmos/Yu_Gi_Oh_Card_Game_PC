package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {
	
public DarkHole(String name, String description){
	super(name, description);
}

public SpellCard clone(){
	return new DarkHole(getName(),getDescription());
	}
public void action(MonsterCard monster){
	ArrayList<MonsterCard> apm = getBoard().getActivePlayer().getField().getMonstersArea();
	//getBoard().getActivePlayer().getField().removeMonsterToGraveyard(apm);
	for(MonsterCard m : apm)
	{
		
		getBoard().getActivePlayer().getField().getGraveyard().add(m);
		m.setLocation(Location.GRAVEYARD);
	}
	apm.clear();
    super.action(monster);
		
	
	}
}

