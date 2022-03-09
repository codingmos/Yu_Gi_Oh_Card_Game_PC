package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

//import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {

	public GracefulDice(String name, String description){
		super(name, description);
	}
	
	public SpellCard clone(){
		return new GracefulDice(getName(),getDescription());
		}

	public void action(MonsterCard monster){
		int random = (int) (Math.random() * 10)+1;
	    int morepoints = random * 100;
		int initialattackpoints; 
		int initialdefensepoints; 
		ArrayList<MonsterCard> apm =  getBoard().getActivePlayer().getField().getMonstersArea();
		//ArrayList<Card> aph =  getBoard().getActivePlayer().getField().getHand();
		for (int i = 0; i<apm.size();i++){
			initialattackpoints = (int) ((apm.get(i)).getAttackPoints());
		    initialdefensepoints = (int) ((apm.get(i)).getDefensePoints());
			(apm.get(i)).setAttackPoints(initialattackpoints + morepoints);
			(apm.get(i)).setDefensePoints(initialdefensepoints + morepoints);
		}
		
		/*for(int i = 0; i<aph.size(); i++){
			if(aph.get(i) instanceof MonsterCard){
			initialattackpoints = ((MonsterCard)aph.get(i)).getAttackPoints();
			initialdefensepoints = ((MonsterCard)aph.get(i)).getDefensePoints();
			((MonsterCard)aph.get(i)).setAttackPoints(initialattackpoints + morepoints);
			((MonsterCard)aph.get(i)).setDefensePoints(initialdefensepoints + morepoints);}
		}*/
	}
	
	
}
