package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {
	public MonsterReborn(String name, String description){
		super(name, description);
	}
	public SpellCard clone(){
		return new MonsterReborn(getName(),getDescription());
		}
	public void action(MonsterCard monster){
		ArrayList<Card> apgrave = getBoard().getActivePlayer().getField().getGraveyard();
		ArrayList<Card> opgrave = getBoard().getOpponentPlayer().getField().getGraveyard();
		
		int max1 = 0;//(int)(((MonsterCard)(apgrave.get(0))).getAttackPoints());
		int max2 = 0;//(int)(((MonsterCard)(opgrave.get(0))).getAttackPoints());
		/*MonsterCard mon1 = new MonsterCard();
		MonsterCard mon2 = new MonsterCard();*/
		
				
		
		MonsterCard maxpower1 = ((MonsterCard)(apgrave.get(0)));
		MonsterCard maxpower2 = ((MonsterCard)(opgrave.get(0))); 
		
		for(int i = 0;i<apgrave.size();i++){
		if (apgrave.get(i) instanceof MonsterCard) {
			if(((MonsterCard) (apgrave.get(i))).getAttackPoints() > max1)
				maxpower1 = (MonsterCard) (apgrave.get(i));
			    max1 = maxpower1.getAttackPoints();
			}
			
		}
		
		for(int j = 0; j < opgrave.size(); j++ ){
			if (opgrave.get(j) instanceof MonsterCard) {
				if(((MonsterCard) (opgrave.get(j))).getAttackPoints() > max2)
					maxpower2 = (MonsterCard) (opgrave.get(j));
				    max2 = maxpower2.getAttackPoints();
				}
		}
		
		
		if(max1 >= max2){
			getBoard().getActivePlayer().getField().addMonsterToField(maxpower1, maxpower1.getMode(), maxpower1.isHidden());
		    getBoard().getActivePlayer().getField().getGraveyard().remove(maxpower1);//(maxpower1, maxpower1.getMode(), maxpower1.isHidden());

		}else{
			getBoard().getActivePlayer().getField().addMonsterToField(maxpower2, maxpower2.getMode(), maxpower2.isHidden());
			getBoard().getOpponentPlayer().getField().getGraveyard().remove(maxpower2);//.addMonsterToField(maxpower1, maxpower1.getMode(), maxpower1.isHidden());

		}
	}
		
	}
	

