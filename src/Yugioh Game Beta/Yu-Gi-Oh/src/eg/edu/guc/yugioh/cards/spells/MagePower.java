package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends SpellCard {
	public MagePower(String name, String description){
		super(name, description);
	}

	public SpellCard clone(){
		return new MagePower(getName(),getDescription());
		}
	public void action(MonsterCard monster){
		ArrayList<MonsterCard> apm = getBoard().getActivePlayer().getField().getMonstersArea();
		ArrayList<SpellCard> aps = getBoard().getActivePlayer().getField().getSpellArea();
		MonsterCard toModify = null;
		for(int i = 0; i<apm.size(); i++){
			if(monster.equals((MonsterCard)(apm.get(i))))
				toModify = ((MonsterCard)(apm.get(i)));
		}
		
		
		if(toModify != null){
			int initialattackpoints;
			int initialdefensepoints;
			for (int i = 0; i<aps.size();i++){
				initialattackpoints = toModify.getAttackPoints();
				initialdefensepoints = toModify.getDefensePoints();
				toModify.setAttackPoints(initialattackpoints+500);
				toModify.setDefensePoints(initialdefensepoints+500);
		    }
		}
	}
	
}
