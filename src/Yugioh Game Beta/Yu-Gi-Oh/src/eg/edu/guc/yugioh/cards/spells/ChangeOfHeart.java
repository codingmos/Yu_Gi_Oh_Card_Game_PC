package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;


public class ChangeOfHeart extends SpellCard {

	public ChangeOfHeart(String name, String description){
		super(name, description);
	}
	public SpellCard clone(){
		return new ChangeOfHeart(getName(),getDescription());
		}
	public void action(MonsterCard monster){
		ArrayList<MonsterCard> opm = getBoard().getOpponentPlayer().getField().getMonstersArea();
		ArrayList<MonsterCard> apm = getBoard().getActivePlayer().getField().getMonstersArea();
//		for(int i = 0; i<opm.size();i++){
//			if(monster.equals(opm.get(i))){
//				getBoard().getActivePlayer().getField().addMonsterToField(opm.get(i),opm.get(i).getMode(), opm.get(i).isHidden());
//				apm.add(opm.remove(i));
//				
//			}
		
//		}
		
		opm.remove(monster);
		apm.add(monster);
	}
}
